package com.tcInfo.entity;

import com.opencsv.bean.CsvBindByPosition;

public class ArticleEntity {

	// タイトル 取得
	@CsvBindByPosition(position = 0, required = true)
	private String title;

	// 本文 取得
	@CsvBindByPosition(position = 1, required = true)
	private String content;

	// URL 取得
	@CsvBindByPosition(position = 2, required = true)
	private String url;

}
