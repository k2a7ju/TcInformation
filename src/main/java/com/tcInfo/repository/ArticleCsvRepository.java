package com.tcInfo.repository;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.tcInfo.constant.ErrorConstant;
import com.tcInfo.entity.ArticleCsvEntity;
import com.tcInfo.entity.ArticleEntity;
import com.tcInfo.error.TcInfoException;

/**
 * Article の Repository クラス
 *
 * @author kaju
 */
@Repository
public class ArticleCsvRepository {
	public List<ArticleCsvEntity> read(String fileName){
		Reader reader = null;
		try {
			reader = Files.newBufferedReader(Paths.get(fileName));
		} catch (IOException e) {
			throw new TcInfoException(ErrorConstant.FILE_NOT_FOUND,e);
		}
        CsvToBean<ArticleCsvEntity> csvToBean = new CsvToBeanBuilder<ArticleEntity>(reader).withType(ArticleEntity.class).build();
        return csvToBean.parse();
    }
}
