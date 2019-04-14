package com.tcInfo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
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

		TcInfoJsonBean jsonBean = this.getJsonObject(jsonText);

		String lang = jsonBean.getLang();
		String category = jsonBean.getCategory();

		System.out.println(category);

//		String commandResult = scriptService.execCommand(command);
//		System.out.println(commandResult);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(requestBean.getBody(),HttpStatus.ACCEPTED);

		return responseEntity;
	}

	private TcInfoJsonBean getJsonObject(String jsonText) {

		ObjectMapper objectMapper = new ObjectMapper();
		TcInfoJsonBean jsonBean = null;
		try {
			jsonBean = objectMapper.readValue(jsonText, TcInfoJsonBean.class);
		} catch (JsonParseException e) {
			// TODO: Exception
		} catch (JsonMappingException e) {
			// TODO: Exception
		} catch (IOException e) {
			// TODO: Exception
		}

		return jsonBean;
	}
}
