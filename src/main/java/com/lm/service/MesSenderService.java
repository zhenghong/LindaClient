package com.lm.service;

import com.lm.model.MesInfo;

public interface MesSenderService {

	public void sendQueue(MesInfo mi);

	public void sendTopic(MesInfo mi);
}
