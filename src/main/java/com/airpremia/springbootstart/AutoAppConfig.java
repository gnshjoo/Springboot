package com.airpremia.springbootstart;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.airpremia.springbootstart.member",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)// 기존 예제를 유지하기 위해 AppConfig를 제외하기 위한 설정
public class AutoAppConfig {


}
