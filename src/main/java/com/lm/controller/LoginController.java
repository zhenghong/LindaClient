package com.lm.controller;

import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lm.api.LoginDataI;
import com.lm.api.LoginDataO;
import com.lm.api.LogoutDataI;
import com.lm.api.LogoutDataO;
import com.lm.model.User;
import com.lm.service.UserService;
import com.lm.service.UserSessionService;

@Controller
public class LoginController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService usi;
	
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
				
		// ÑéÖ¤
		User user = usi.getUserEntityById(input.getUserId());
		if( null == user || !user.getPassword().equals(input.getPassword())){
			result.setEc("1");
			result.setEm("userid or password Error! ");
			return result;
		}
		result.setUserName(user.getUserName());
		
		// session redis »º´æ
		//String SID = ussi.add(user);
				
		// Êä³ö
		//result.setSID(SID);
		
		return result;
	}
	
	@RequestMapping("/user/logout")
	public @ResponseBody LogoutDataO login(LogoutDataI input, LogoutDataO result) {
				
		logger.debug("sid="+input.getSid());
		
		// session redis »º´æ
		//ussi.delete(input.getSid());
		
		return result;
	}		

}