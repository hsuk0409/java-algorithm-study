package com.spring.corestudy.beandefinition;

import com.spring.corestudy.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig .class);
//    GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.class");

    @DisplayName("빈 설정 메타정보 확인 (**중요:: BeanDefinition 추상화)")
    @Test
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName= " + beanDefinitionName +
                        ", beanDefinition= " + beanDefinition);
            }
        }
    }
}
