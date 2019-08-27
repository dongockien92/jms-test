package com.uitgis.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class JmsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsTestApplication.class, args);
	}

	// Only required due to defining myFactory in the receiver

//	@Bean
//	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
//			DefaultJmsListenerContainerFactoryConfigurer configurer) {
//		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//		configurer.configure(factory, connectionFactory);
//		return factory;
//	}

	// Serialize message content to json using TextMessage
	/*
	 * @Bean public MessageConverter jacksonJmsMessageConverter() {
	 * MappingJackson2MessageConverter converter = new
	 * MappingJackson2MessageConverter(); converter.setTargetType(MessageType.TEXT);
	 * converter.setTypeIdPropertyName("_type"); return converter; }
	 */
}
