package com.lm.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lm.api.ResultData;
import com.lm.model.Transfer;
import com.lm.service.TranService;

@Controller
public class TranController extends BaseController{

	private static final Logger logger = LoggerFactory.getLogger(TranController.class);
	
	@Autowired
	private TranService tsi;
				    
	@RequestMapping("/user/tranFlow")
	public @ResponseBody List<Transfer> tranFlow() throws NoSuchAlgorithmException {
				
		List<Transfer> tfrs = tsi.tranFlow();
		return tfrs;
	}
	
	@RequestMapping("/user/transfer")
	public @ResponseBody ResultData transfer(Transfer tfr) {
		
		tfr.setFlowno("pb000001");
		tfr.setTime("2016/01/18");
		
		tsi.transfer(tfr);
		
		return new ResultData(); 
	}		

}