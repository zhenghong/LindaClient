package com.lm.controller;

import java.security.NoSuchAlgorithmException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lm.api.ResultData;

public class BaseController {
	
	/** 基于@ExceptionHandler异常处理 */
	@ExceptionHandler
	public  @ResponseBody ResultData exp(Exception ex) {

		ResultData error = new ResultData();

		// 根据不同错误更新model
		if (ex instanceof NoSuchAlgorithmException) {
			error.setEc("1");
			error.setEm("获取SID失败！");
			return error;
		} else {
			error.setEc("9");
			error.setEm(ex.getLocalizedMessage());
			return error;
		}
	}

}
