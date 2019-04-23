package com.tcInfo.error;

/**
 * 例外処理クラス
 *
 * @author kaju
 */
public class TcInfoException extends RuntimeException {

	private String message;;

	/**
	 * コンストラクタ
	 *
	 * @param message
	 */
	public TcInfoException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * コンストラクタ
	 *
	 * @param message
	 * @param exception
	 */
	public TcInfoException(String message, Throwable exception) {
		super(message,exception);
		this.message = message;
	}

	/**
	 * message の getter
	 * return message
	 */
	public String getMessage() {
		return this.message;
	}

}
