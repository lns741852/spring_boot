package com.jay.rabbit;

import com.jay.rabbit.bean.Book;
import com.jay.rabbit.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;

@SpringBootTest
class DemoApplicationTests {


	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	void rabbitSend() {
		HashMap<Object, Object> map = new HashMap<>();
		map.put("msg","Hi");
		map.put("data", Arrays.asList("hello",123,true));
		rabbitTemplate.convertAndSend("cola.direct","cola.news",new Book("JAVA開發"));
	}

	@Test
	void rabbitReceive() {
		Object queues = rabbitTemplate.receiveAndConvert("jay.news");
		System.out.print(queues);

	}

	/* 創建交換器 / 對列 / Binding  刪除*/
	@Test
	void createRabbit() {
		amqpAdmin.declareExchange(new DirectExchange(("test.exchange")));

		amqpAdmin.declareQueue(new Queue("test.news",true));

		amqpAdmin.declareBinding(new Binding("test.news",Binding.DestinationType.QUEUE,"test.exchange","test.news",null));

		amqpAdmin.deleteExchange("test.exchange");

	}





}
