package com.gooner.dhaka.bhogatedotcom.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PropertyReader {

    @Value("${enterprise.email}")
    private String email;

    @Value("${enterprise.phone}")
    private String phone;

    /*@PostConstruct
    public void init(){

      log.info("Email is: " +email+" phone is: "+phone);

    }*/

    /*public void logMethod(){
        log.info("Email is: " +email+" phone is: "+phone);
    }*/

}
