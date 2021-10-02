package com.spring.corestudy.singleton.stateful;

import com.spring.corestudy.TestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulServiceTest {
    @DisplayName("싱글 스레드에서 상태 유지 싱글톤 빈은 서로 개체를 공유한다.")
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        statefulService1.order("userA", 10000);
        statefulService2.order("userB", 20000);

        int userAPrice = statefulService1.getPrice();
        int userBPrice = statefulService2.getPrice();

        System.out.println("userA price= " + userAPrice);
        System.out.println("userB price= " + userBPrice);

        assertThat(statefulService1).isSameAs(statefulService2);
        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }
}
