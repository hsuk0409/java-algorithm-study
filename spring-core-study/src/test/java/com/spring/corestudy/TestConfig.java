package com.spring.corestudy;

import com.spring.corestudy.singleton.stateful.StatefulService;
import com.spring.corestudy.singleton.stateless.StatelessService;
import org.springframework.context.annotation.Bean;

public class TestConfig {
    @Bean
    public StatefulService statefulService() {
        return new StatefulService();
    }

    @Bean
    public StatelessService statelessService() {
        return new StatelessService();
    }
}
