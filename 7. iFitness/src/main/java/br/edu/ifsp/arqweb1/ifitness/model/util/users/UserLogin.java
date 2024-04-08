package br.edu.ifsp.arqweb1.ifitness.model.util.users;

import java.util.List;

import br.edu.ifsp.arqweb1.ifitness.model.User;

public class UserLogin {

	private UserLogin() {}

	public static User login(String email, String password) throws Exception {
		List<User> users = UsersReader.read();

		if (users != null) {
			for (User user : users) {
				if (user.getEmail().equals(email) && user.getPassword().equals(PasswordEncoder.encode(password))) {
					return user;
				}
			}
		}
		
		throw new Exception("User not found");
	}

}