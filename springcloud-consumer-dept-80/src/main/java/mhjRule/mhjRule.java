package mhjRule;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mhjRule {
    @Bean
    public IRule myRule() {
        return new MhjRandomRule();
    }
}
