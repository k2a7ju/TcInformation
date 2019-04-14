package com.tcInfo.service;

import org.springframework.http.ResponseEntity;

import com.tcInfo.bean.RequestBean;

public abstract class EndpointService {
	abstract ResponseEntity<String> exec(RequestBean requestBean);
}
