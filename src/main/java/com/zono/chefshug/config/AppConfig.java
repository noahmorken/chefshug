package com.zono.chefshug.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.zono.chefshug.dao")
public class AppConfig {


}
