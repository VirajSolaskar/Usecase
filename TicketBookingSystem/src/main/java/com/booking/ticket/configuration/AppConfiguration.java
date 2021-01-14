/**
 * 
 */
package com.booking.ticket.configuration;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;


/**
 * @author Viraj Solaskar
 *
 */
@Configuration
@EnableJms
public class AppConfiguration {

	@Value("${activemq.broker-url}")
	private String brokerURL;
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("ticket.queue");
	}
	
	@Bean
	public ActiveMQConnectionFactory activeMqueueConnections() {
		ActiveMQConnectionFactory factory= new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerURL);
		return factory;
	}
	
	@Bean
	public JmsTemplate jmstemplate() {
		return new JmsTemplate(activeMqueueConnections());
	}
	
	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);
	    converter.setTypeIdPropertyName("_ticket_");
	    return converter;
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory myFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		return factory;
	}
}
