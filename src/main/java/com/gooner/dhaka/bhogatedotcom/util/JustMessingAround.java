package com.gooner.dhaka.bhogatedotcom.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:random.properties")
public class JustMessingAround {

    @Autowired
    Environment environment;

    public String getEmail(){
        return environment.getProperty("enterprise.name");
    }

    public String getDegree(){
        return environment.getProperty("enterprise.degree");
    }

    @PostConstruct
    public void init(){

      log.info("The name is: "+getEmail()+", The degree is: "+getDegree());
    }

}
