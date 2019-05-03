package com.tcInfo.endpoint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.tcInfo.bean.RequestBean;
import com.tcInfo.constant.ErrorConstant;
import com.tcInfo.error.TcInfoException;

@ControllerAdvice(assignableTypes = TcInfoEndpoint.class)
public class TcInfoControllerAdvice {

	@ModelAttribute
	public RequestBean attribute(HttpServletRequest request, @RequestHeader HttpHeaders httpHeaders,
            @RequestBody String body) {
		RequestBean requestBean = new RequestBean();

		// id を RequestBean へ追加
		String id = httpHeaders.getFirst("id");
		if (id == null) {
			// TODO: Exception id が null
		}

		// password を RequestBean へ追加
		String password =  httpHeaders.getFirst("password");
		if (password == null) {
			// TODO: Exception password が null
		}

		// contentType を RequestBean へ追加
		String contentType = httpHeaders.getContentType().toString();
		if (contentType == null || !contentType.equals(MediaType.APPLICATION_JSON.toString())) {
			throw new TcInfoException(ErrorConstant.CONTENT_TYPE_FAILED);
			// TODO: Exception content-type が不正
		}
		requestBean.setContentType(contentType);

		if (body == null) {
			// TODO: Exception body が空
		}
		requestBean.setBody(body);


		return requestBean;
	}

}
