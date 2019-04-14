package com.tcInfo.bean;

/**
 * リクエストで渡される JSON の Bean クラス
 *
 * @author kaju
 */
public class TcInfoJsonBean {
	private String lang;
	private String category;

	/**
	 * lang の getter
	 * @return lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * category の getter
	 * @return category
	 */
	public String getCategory() {
		return category;
	}
}
