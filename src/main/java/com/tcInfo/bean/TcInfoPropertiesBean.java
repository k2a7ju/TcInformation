package com.tcInfo.bean;

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

    /**
     * @return commandPath
     */
    public String getCsvPath() {
        return this.csvPath;
    }

}
