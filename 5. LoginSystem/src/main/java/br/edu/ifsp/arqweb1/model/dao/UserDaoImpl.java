package br.edu.ifsp.arqweb1.model.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arqweb1.model.User;

public class UserDaoImpl implements UserDao{

	private static UserDaoImpl instance;
    private List<User> userList;

    private UserDaoImpl() {
    	userList = new ArrayList<>();
    }

    public static UserDaoImpl getInstance() {
    	if (instance == null) {
    		instance = new UserDaoImpl();
    	}

    	return instance;
    }

	@Override
	public boolean insert(User user) {
		if(userList != null) {
			if (!userList.contains(user)) {
				userList.add(user);
				return true;
			}
		}
		return false;
	}
	@Override
	public User getByEmail(String email) {
		if (!userList.isEmpty()) {
			for (User user : userList) {
				if (user.getEmail().equals(email)) {
					return user;
				}
			}
		}
		return null;
	}
}
