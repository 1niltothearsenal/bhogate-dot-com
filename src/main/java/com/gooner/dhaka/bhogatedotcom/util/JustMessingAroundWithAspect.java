package com.gooner.dhaka.bhogatedotcom.util;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class JustMessingAroundWithAspect {

    //this is where we add all of our related advices for logging

    //let's start with an @Before advice
    //Run this code BEFORE - target object method: "public void logTheProperties()"
    @Before("execution(public void logTheProperties())")
    public void beforeLogTheProperties(){
        log.info("This method has @Before signature, so you know where it shall run.. :)");
    }


}
