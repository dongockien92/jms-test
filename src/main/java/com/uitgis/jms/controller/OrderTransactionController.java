package com.uitgis.jms.controller;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uitgis.jms.entity.OrderTransaction;

@RestController
@RequestMapping("/transaction")
public class OrderTransactionController {
	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${jms.queue.destination}")
	private String destination;

	@PostMapping(value = "/send")
	public void send(@RequestBody OrderTransaction transaction) {
		System.out.println("Sending a transaction.");
		jmsTemplate.convertAndSend(destination, transaction, new MessagePostProcessor() {

			@Override
			public Message postProcessMessage(Message msg) throws JMSException {
				System.out.println(">>>>>>>>>" + msg.toString());
				msg.setStringProperty("AAAAAAA", "sssssss");
				return msg;
			}
		});
	}
}
