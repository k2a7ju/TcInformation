package com.tcInfo.bean;

/**
 * リクエストの Bean クラス
 *
 * @author kaju
 */
public class RequestBean {

	private String id;

	private String password;

	private String contentType;

	private String body;

	/**
	 * id の getter
	 *
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * id の setter
	 *
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * password の getter
	 *
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * password の setter
	 *
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * contentType の getter
	 *
	 * @return contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * contentType の setter
	 *
	 * @param contentType
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * body の getter
	 *
	 * @return body
	 */
	public String getBody() {
		return body;
	}

	/**
	 * body の setter
	 *
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}

}
