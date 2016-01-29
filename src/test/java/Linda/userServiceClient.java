package Linda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lm.service.UserService;

public class userServiceClient {
	private static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("config/cxf-client.xml");
		UserService usi = (UserService) context.getBean("userService");
		
		usi.insert();
		
	}
}
