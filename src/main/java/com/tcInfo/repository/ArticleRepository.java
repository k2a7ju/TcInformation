package com.tcInfo.repository;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.tcInfo.entity.ArticleEntity;

/**
 * Article の Repository クラス
 *
 * @author kaju
 *
 */
@Repository
public class ArticleRepository {
	public List<ArticleEntity> read(String fileName){
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(fileName));
		} catch (IOException e) {
			// TODO: Exception: throw ファイルが存在しません。
		}
        CsvToBean<ArticleEntity> csvToBean = new CsvToBeanBuilder<ArticleEntity>(reader).withType(ArticleEntity.class).build();
        return csvToBean.parse();
    }
}
