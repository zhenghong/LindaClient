package com.lm.service;

import java.util.List;

import com.lm.model.User;

public interface UserService {

	User getUserEntityById(String userId);

	List<User> getUserEntities();

	User insertUserEntity(User userEntity);

	void insert();
	
	void delete(String userId);

}
