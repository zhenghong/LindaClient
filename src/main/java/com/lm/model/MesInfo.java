package com.lm.model;

import java.io.Serializable;

public class MesInfo implements Serializable {

	private static final long serialVersionUID = 8519331604274874257L;

	private String beanName;
	private String methodName;
	private Object[] params;

	public MesInfo(String beanName, String methodName, Object[] params) {
		
		this.beanName = beanName;
		this.methodName = methodName;
		this.params = params;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}
	
}
