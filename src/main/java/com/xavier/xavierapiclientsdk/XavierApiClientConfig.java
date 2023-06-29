package com.xavier.xavierapiclientsdk;

import com.xavier.xavierapiclientsdk.client.XavierApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ComponentScan
@ConfigurationProperties("xavierapi.client")
public class XavierApiClientConfig {

    private String accessKey;
    private String secretKey;

    @Bean
    public XavierApiClient xavierApiClient(){
        return new XavierApiClient(accessKey, secretKey);
    }
}
