package mhjRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mhjRule {
    @Bean
    public IRule myRule() {
//        return new MhjRandomRule();
        return new RoundRobinRule();
    }
}
