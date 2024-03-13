package br.edu.ifsp.arqweb1.model.dao;

import br.edu.ifsp.arqweb1.model.User;

public interface UserDao {
	
	boolean insert(User user);
	
	User getByEmail(String email);

	boolean validate(User user, String password);
}
