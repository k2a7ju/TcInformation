package com.tcInfo.service;

import org.springframework.http.ResponseEntity;

import com.tcInfo.bean.RequestBean;

/**
 * エンドポイントクラスの抽象クラス
 *
 * @author kaju
 */
public abstract class EndpointService {
	abstract ResponseEntity<String> get(RequestBean requestBean);
	abstract ResponseEntity<String> update();
}
