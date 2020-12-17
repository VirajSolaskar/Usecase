package com.example.message2queue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.message2queue.dto.PFRequestDto;
import com.example.message2queue.service.PFService;

@RestController
public class PFController {
	@Autowired
	PFService pfService;
	@PostMapping(value = "/providentfund",
			 consumes = {
					 "application/JSON",
					 "application/XML"
			 },
			 produces = {
					 "application/JSON",
					 "application/XML"
			 })
	public ResponseEntity<String> setPFDetails(@RequestBody PFRequestDto pfrequest) {
		String msg = null;
		try {
		msg = pfService.pfDetails(pfrequest);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}

}
