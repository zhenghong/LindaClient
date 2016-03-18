package com.lm.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lm.api.LoginDataI;
import com.lm.api.LoginDataO;
import com.lm.api.LogoutDataI;
import com.lm.api.LogoutDataO;
import com.lm.model.User;
import com.lm.service.RedisServiceCluster;
import com.lm.service.UserService;

@Controller
public class LoginController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService usi;
	@Autowired
	private RedisServiceCluster redisCluster;
	//@Autowired
	//private UserSessionService ussi;
	
	@RequestMapping("/testTX")
	public @ResponseBody LoginDataO testTx(LoginDataI input, LoginDataO result) throws NoSuchAlgorithmException {
		
		usi.insert();
		return result;
	}	
	
	@RequestMapping("/testAsync")
	public @ResponseBody LoginDataO testAsync(LoginDataI input, LoginDataO result) throws NoSuchAlgorithmException {
				
		usi.delete("997");
		return result;
	}		
		    
	@RequestMapping("/user/login")
	public @ResponseBody LoginDataO login(LoginDataI input, LoginDataO result) throws NoSuchAlgorithmException {
				
		// —È÷§
		User user = usi.getUserEntityById(input.getUserId());
		if( null == user || !user.getPassword().equals(input.getPassword())){
			result.setEc("1");
			result.setEm("userid or password Error! ");
			return result;
		}
		result.setUserName(user.getUserName());
		
		// ª∫¥Ê
		Map<String, String> us = new HashMap<String, String>();
		us.put("id", user.getUserId());
		us.put("name", user.getUserName());
		us.put("email", user.getEmail());
		redisCluster.addHash(user.getUserId(), us);
		
		return result;
	}
	
	@RequestMapping("/user/logout")
	public @ResponseBody LogoutDataO login(LogoutDataI input, LogoutDataO result) {
				
		logger.debug("sid="+input.getSid());
		
		// session redis ª∫¥Ê
		//ussi.delete(input.getSid());
		
		return result;
	}		

}