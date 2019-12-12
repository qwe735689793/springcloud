package springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Configuration
public class configBean {
    //构造ResmTemplate
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
