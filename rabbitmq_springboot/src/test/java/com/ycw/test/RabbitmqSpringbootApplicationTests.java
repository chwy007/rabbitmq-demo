package com.ycw.test;

import com.ycw.RabbitmqSpringbootApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest//(classes= RabbitmqSpringbootApplication.class)
@RunWith(SpringRunner.class)
class RabbitmqSpringbootApplicationTests {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	public void helloword() {
		rabbitTemplate.convertAndSend("msg1","very important message 机密");
	}

	@Test
	public void work(){
		for (int i=0;i<10;i++){
			rabbitTemplate.convertAndSend("msg2",i+"very important message 机密***");

		}
	}

	@Test
	public void fanout(){
		for (int i=0;i<10;i++){
			rabbitTemplate.convertAndSend("logs","",i+"very important message 机密***");

		}
	}


	@Test
	public void routing(){
		for (int i=0;i<10;i++){
			if(i%2==0) rabbitTemplate.convertAndSend("logs-1","error",i+"very important message 机密***");
			if(i%2==1) rabbitTemplate.convertAndSend("logs-1","info",i+"very important message 机密***");

		}
	}

	@Test
	public void topic(){
			rabbitTemplate.convertAndSend("logs-2","user.item.save","very important message 机密***");

	}

}
