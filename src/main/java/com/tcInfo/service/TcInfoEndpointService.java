package com.tcInfo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcInfo.bean.ArticleListBean;
import com.tcInfo.bean.RequestBean;
import com.tcInfo.bean.TcInfoJsonBean;
import com.tcInfo.constant.ErrorConstant;
import com.tcInfo.entity.ArticleEntity;
import com.tcInfo.error.TcInfoException;
import com.tcInfo.repository.ArticleRepository;

/**
 * Techcrunch の情報取得用 Endpoint クラス
 *
 * @author kaju
 */
@Service
public class TcInfoEndpointService extends EndpointService {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	ScriptService scriptService;

	public ResponseEntity<String> exec(RequestBean requestBean) {

		// requestBean が null のときエラー
		if (requestBean == null) {
			throw new TcInfoException(ErrorConstant.REQUEST_BEAN_NULL);
		}
		String jsonText = requestBean.getBody();

		TcInfoJsonBean jsonBean = this.getJsonObject(jsonText);

		// TODO: jsonBean　バリデーション処理

		String lang = jsonBean.getLang();
		String category = jsonBean.getCategory();

		String command = scriptService.buildCommand(category);
		String commandResult = scriptService.execCommand(command);

		List<ArticleEntity> entityList = articleRepository.read("/Users/kaju/WorkSpace/eclipse_work/Tcinformation/script/output.csv");

		String json = this.toJson(entityList);


		ResponseEntity<String> responseEntity = new ResponseEntity<String>(json,HttpStatus.OK);

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
	private String toJson(List<ArticleEntity> entityList) {
		String json = "";
		ArticleListBean articleListBean = new ArticleListBean(entityList);
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(articleListBean);
		} catch (JsonProcessingException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return json;
	}
}
