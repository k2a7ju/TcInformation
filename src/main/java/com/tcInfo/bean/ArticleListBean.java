package com.tcInfo.bean;

import java.util.List;

import com.tcInfo.entity.ArticleEntity;

public class ArticleListBean {
	public List<ArticleEntity> article;

	public ArticleListBean(List<ArticleEntity> list) {
		this.article = list;
	}

}
