package com.airpremia.springbootstart.BeanFind;

import com.airpremia.springbootstart.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();

        for (String beanDefinitionNames : beanDefinitionName) {
            Object bean = ac.getBean(beanDefinitionNames);
            System.out.println("name = " + beanDefinitionNames + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionName = ac.getBeanDefinitionNames();

        for (String beanDefinitionNames : beanDefinitionName) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionNames);
            //
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionNames);
                System.out.println("name = " + beanDefinitionNames + " object = " + bean);
            }
            if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = ac.getBean(beanDefinitionNames);
                System.out.println("name = " + beanDefinitionNames + " object = " + bean);
            }
        }
    }


}
