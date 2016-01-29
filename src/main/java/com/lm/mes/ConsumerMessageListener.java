package com.lm.mes;

import java.lang.reflect.Method;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

import com.lm.model.MesInfo;
import com.lm.utils.SpringContextUtil;

@Service("consumerMessageListener")
public class ConsumerMessageListener implements MessageListener {

	public void onMessage(Message message) {

		if (message instanceof ObjectMessage) {

			ObjectMessage objMsg = (ObjectMessage) message;
			try {

				MesInfo mes = (MesInfo) objMsg.getObject();
				Object bean = (SpringContextUtil.getBean(mes.getBeanName()));
				invokeMethod(bean, mes.getMethodName(), mes.getParams());
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} else {

			TextMessage textMsg = (TextMessage) message;
			try {

				System.out.println(textMsg.getText());
			} catch (JMSException ex) {
				ex.printStackTrace();
			}
		}
	}

	public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {

		Class<? extends Object> ownerClass = owner.getClass();

		Class<?>[] argsClass = new Class[args.length];
		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getMethod(methodName, argsClass);

		return method.invoke(owner, args);
	}

}