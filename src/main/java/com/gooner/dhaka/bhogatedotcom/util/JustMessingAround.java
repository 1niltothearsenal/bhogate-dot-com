package com.gooner.dhaka.bhogatedotcom.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.Date;

@Slf4j
@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:random.properties")
public class JustMessingAround {

    @Autowired
    private Environment environment;

    @Autowired
    ReadingFromAFile readingFromAFile;

    public String getName(){
        return environment.getProperty("enterprise.name");
    }

    public String getDegree(){
        return environment.getProperty("enterprise.degree");
    }

   /* @PostConstruct
    public void init(){

      log.info("The name is: "+getEmail()+", The degree is: "+getDegree());
    }*/


    public void logTheProperties() {
        log.info("The name is: "+getName()+", The degree is: "+getDegree());

        String json = null;
        try {
            json = readingFromAFile.getJson();
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info(json);
        Date date = new Date();
        log.info(date.toString());
    }

}
