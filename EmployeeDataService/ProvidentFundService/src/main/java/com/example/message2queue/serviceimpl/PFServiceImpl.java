package com.example.message2queue.serviceimpl;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.message2queue.dto.PFRequestDto;
import com.example.message2queue.service.PFService;
@Service
public class PFServiceImpl implements PFService{
	@Autowired
	Queue queue;
	@Autowired
	JmsTemplate jmsTemplate;

	@Override
	public String pfDetails(PFRequestDto pfrequest) {
		// TODO Auto-generated method stub
		jmsTemplate.convertAndSend(queue,pfrequest);
		return "Success";
	}

}
