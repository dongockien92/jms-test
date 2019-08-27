package com.uitgis.jms.component;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.uitgis.jms.entity.OrderTransaction;

@Component
public class OrderTransactionReceiver {
//	@Autowired
//	private OrderTransactionRepository transactionRepository;

	private int count = 1;

	@JmsListener(destination = "${jms.queue.destination}")
	public void receiveMessage(OrderTransaction transaction) {
		System.out.println("<" + count + "> Received <" + transaction + ">");
		count++;
		// throw new RuntimeException();
		// transactionRepository.save(transaction);
	}
}
