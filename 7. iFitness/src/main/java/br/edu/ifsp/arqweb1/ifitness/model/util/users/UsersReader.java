package br.edu.ifsp.arqweb1.ifitness.model.util.users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.edu.ifsp.arqweb1.ifitness.model.User;

public class UsersReader {
	public static List<User> read(){
		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
		List <User> users = null;
		String path = "C:\\Users\\cauar\\Documents\\Nova pasta\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\7. iFitness\\data\\userData.json";
		
		try {
			File file = new File(path);
			
			if(file.exists()) {
				BufferedReader buffer = new BufferedReader(new FileReader(path));
				TypeToken<List<User>> type = new TypeToken<List<User>>() {};
				users = gson.fromJson(buffer, type);
				buffer.close();
			}
		} catch (IOException e){
			e.printStackTrace();
		}
		return users;
	}
	
	public static User findUserByEmail(String encryptedEmail) throws Exception {

		List<User> users = read();

		if (users != null) {
			for (User user : users) {
				if (PasswordEncoder.encode(user.getEmail()).equals(encryptedEmail)) {
					return user;
				}
			}
		}

		throw new Exception("User not found");
	}
}