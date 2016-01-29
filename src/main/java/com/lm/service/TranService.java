package com.lm.service;

import java.util.List;

import com.lm.model.Transfer;

public interface TranService {

	List<Transfer> tranFlow();
	
	void transfer(Transfer tf);
			
}
