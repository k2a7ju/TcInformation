package com.tcInfo.constant;

public class ErrorConstant {
	/*
	 * ハンドリングしていないエラーが発生した場合に出力するメッセージ
	 */
	public static final String INTERNAL_SERVER_ERROR = "Internal Server Error";

	/*
	 * 外部コマンド実行に失敗した場合に出力するメッセージ
	 */
	public static final String COMMAND_EXEC_ERROR = "Command Execution error";

	/*
	 * リクエストに含まれる Content-type が JSON 以外の時に出力するメッセージ
	 */
	public static final String CONTENT_TYPE_FAILED = "Content-type is only application/json";

	/*
	 * 記事ファイルが存在しない場合に出力するメッセージ
	 */
	public static final String FILE_NOT_FOUND = "File not found";
}
