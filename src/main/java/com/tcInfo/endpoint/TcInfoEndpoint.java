package com.tcInfo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tcInfo.bean.RequestBean;
import com.tcInfo.service.TcInfoEndpointService;

@RestController
public class TcInfoEndpoint {
	@Autowired
    TcInfoEndpointService endpointService;

	/*
	 * 記事を取得するエンドポイント
	 */
	@RequestMapping(path = "/tcinfo/article/get", method = RequestMethod.POST)
    public ResponseEntity<String> getEndpointService(RequestBean requestBean) {
        ResponseEntity<String> response = this.endpointService.get(requestBean);
        return response;
    }


	/*
	 * 記事を取得するエンドポイント
	 */
	@RequestMapping(path = "/tcinfo/article/update", method = RequestMethod.POST)
    public ResponseEntity<String> updateEndpointService(RequestBean requestBean) {
        ResponseEntity<String> response = this.endpointService.update();
        return response;
    }
}
