package com.gooner.dhaka.bhogatedotcom.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Aspect
public class PlayingWithAspectJ {

    @Before("execution(public void logMethod())")
    public void callMeBeforelogMethod(){
        log.info("You know Why I was called!!!");
    }

}
