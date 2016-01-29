package com.lm.service;

import com.lm.model.User;

public interface UserSessionService {

	String add(User user);

	User get(String id);

	void delete(String id);
}
