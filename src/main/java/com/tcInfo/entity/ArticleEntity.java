package com.tcInfo.entity;

import com.opencsv.bean.CsvBindByPosition;

/**
 * Article の Entity クラス
 *
 * @author kaju
 */
public class ArticleEntity {

	// タイトル 取得
	@CsvBindByPosition(position = 0, required = true)
	public String title;

	// 本文 取得
	@CsvBindByPosition(position = 1, required = true)
	public String content;

	// URL 取得
	@CsvBindByPosition(position = 2, required = true)
	public String url;

}
