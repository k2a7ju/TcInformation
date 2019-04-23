package com.tcInfo.error;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcInfo.constant.ErrorConstant;

@ControllerAdvice
public class TcInfoExceptionHandler extends ResponseEntityExceptionHandler{

	private static String INTERNAL_SERVER_ERROR_BODY = String.format("{\"message\":\"%s\"}", ErrorConstant.INTERNAL_SERVER_ERROR);
	private static HttpStatus status = HttpStatus.BAD_REQUEST;

	@ExceptionHandler(TcInfoException.class)
    @ResponseBody
	public ResponseEntity<String> TcInfoExceptionHandling(HttpServletRequest request, TcInfoException exception){
		String message = exception.getMessage();

		HashMap<String,String> map = new HashMap<String,String>();
		map.put("message", message);

		String json = "";
		System.out.print("aaa");
		try {
			json = new ObjectMapper().writeValueAsString(map);
		} catch(Exception e) {
			json = INTERNAL_SERVER_ERROR_BODY;
		}
		HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(json, headers, status);

		return responseEntity;
	}


	@ExceptionHandler(Exception.class)
    @ResponseBody
	public ResponseEntity<String> ExceptionHandling (Exception exception){
		String message = ErrorConstant.INTERNAL_SERVER_ERROR;

		HashMap<String,String> map = new HashMap<String,String>();
		String json = "";

		try {
			json = new ObjectMapper().writeValueAsString(map);
		} catch(Exception e) {
			json = INTERNAL_SERVER_ERROR_BODY;
		}
		HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(json, headers, status);

		return responseEntity;

	}
}
