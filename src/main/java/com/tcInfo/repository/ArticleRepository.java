package com.tcInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcInfo.entity.ArticleEntity;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer> {

}
