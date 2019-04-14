package com.tcInfo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcInfo.bean.RequestBean;
import com.tcInfo.bean.TcInfoJsonBean;
import com.tcInfo.repository.ArticleRepository;

@Service
public class TcInfoEndpointService extends EndpointService {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	ScriptService scriptService;

	public ResponseEntity<String> exec(RequestBean requestBean) {

		if (requestBean == null) {
			// TODO: Exception requestBean が null
		}
		String jsonText = requestBean.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		TcInfoJsonBean jsonBean = null;
		try {
			jsonBean = objectMapper.readValue(jsonText, TcInfoJsonBean.class);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println(jsonBean.getLang());

//		String commandResult = scriptService.execCommand(command);
//		System.out.println(commandResult);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(requestBean.getBody(),HttpStatus.ACCEPTED);

		return responseEntity;
	}

}
