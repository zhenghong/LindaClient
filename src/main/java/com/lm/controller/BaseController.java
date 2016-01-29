package com.lm.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lm.api.ResultData;

public class BaseController {
	
	/** ����@ExceptionHandler�쳣���� */
	@ExceptionHandler
	public  @ResponseBody ResultData exp(Exception ex) {

		ResultData error = new ResultData();

		// ���ݲ�ͬ�������model
		if (ex instanceof NoSuchAlgorithmException) {
			error.setEc("1");
			error.setEm("��ȡSIDʧ�ܣ�");
			return error;
		} else {
			error.setEc("9");
			error.setEm(ex.getLocalizedMessage());
			return error;
		}
	}

}
