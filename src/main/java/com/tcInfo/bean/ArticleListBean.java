package com.tcInfo.bean;

import java.util.List;

import com.tcInfo.entity.ArticleEntity;

/**
 * ArticleList の Bean クラス
 *
 * @author kaju
 *
 */
public class ArticleListBean {
	public List<ArticleEntity> article;

	public ArticleListBean(List<ArticleEntity> list) {
		this.article = list;
	}

}
