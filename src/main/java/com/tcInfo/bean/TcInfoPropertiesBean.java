package com.tcInfo.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:tcInfo.properties")
@ConfigurationProperties
public class TcInfoPropertiesBean {

    @Value("${csv.path}")
    private String csvPath;

    @Value("${category.list}")
    private List<String> categoryList;

    /**
     * @return commandPath
     */
    public String getCsvPath() {
        return this.csvPath;
    }

    /**
     * @return categoryList
     */
	public List<String> getCategoryList() {
		return categoryList;
	}

}
