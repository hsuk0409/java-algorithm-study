package com.spring.corestudy.singleton.stateless;

import com.spring.corestudy.TestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class StatelessServiceTest {

    @DisplayName("싱글 스레드에서 상태 유지하지 않는 싱글톤 빈은 각 독립적인 값을 갖는다.")
    @Test
    void statelessSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService statelessService1 = ac.getBean("statelessService", StatelessService.class);
        StatelessService statelessService2 = ac.getBean("statelessService", StatelessService.class);

        int userAPrice = statelessService1.order("userA", 10000);
        int userBPrice = statelessService2.order("userB", 20000);

        assertThat(statelessService1).isSameAs(statelessService2);
        assertThat(userAPrice).isEqualTo(10000);
        assertThat(userBPrice).isEqualTo(20000);
    }
}
