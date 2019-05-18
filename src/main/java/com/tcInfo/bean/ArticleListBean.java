package com.tcInfo.bean;

import java.util.List;

import com.tcInfo.entity.ArticleCsvEntity;

/**
 * ArticleList の Bean クラス
 *
 * @author kaju
 *
 */
public class ArticleListBean {
	public List<ArticleCsvEntity> article;

	public ArticleListBean(List<ArticleCsvEntity> list) {
		this.article = list;
	}

}
