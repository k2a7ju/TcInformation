package com.tcInfo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Article の Entity クラス
 *
 * @author kaju
 */
@Entity
@Table(name="article")
public class ArticleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "title", nullable = false, length = 255)
	private String title;

	@Column(name = "content", nullable = false, length = 255)
	private String content;

	@Column(name = "url", nullable = false, length = 255, unique = true)
	private String url;

	@Column(name = "category", nullable = false, length = 255)
	private String category;

}
