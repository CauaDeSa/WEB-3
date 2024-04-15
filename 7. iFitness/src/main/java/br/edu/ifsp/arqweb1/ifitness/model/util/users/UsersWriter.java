package br.edu.ifsp.arqweb1.ifitness.model.util.users;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.edu.ifsp.arqweb1.ifitness.model.User;

public class UsersWriter {
	public static Boolean write(User user) {
		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
		List <User> users = UsersReader.read();
		String path = "C:\\Users\\cauar\\Documents\\Nova pasta\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\7. iFitness\\data\\userData.json";
		
		if (users == null) {
			users = new ArrayList<>();
			user.setId(1L);
		} else {
			for (User u : users) {
				if (u.getEmail().equals(user.getEmail()))
					return false;
			}
			user.setId(users.get(users.size() - 1).getId() + 1);
		}
		
		user.setPassword(PasswordEncoder.encode(user.getPassword()));
		
		users.add(user);
		
		String json = gson.toJson(users);
		try {
			FileWriter writer = new FileWriter(path);
			writer.write(json);
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
