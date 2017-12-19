package org.fleamarket.user.service;

import org.fleamarket.user.model.User;

public interface UserService {
	public User findUserByUsername(String username);
	public void saveUser(User user);
}
