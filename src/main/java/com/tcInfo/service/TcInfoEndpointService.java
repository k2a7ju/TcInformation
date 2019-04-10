package com.tcInfo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class TcInfoEndpointService {

	public ResponseEntity<String> exec() {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("sample",HttpStatus.ACCEPTED);

		return responseEntity;
	}

}
