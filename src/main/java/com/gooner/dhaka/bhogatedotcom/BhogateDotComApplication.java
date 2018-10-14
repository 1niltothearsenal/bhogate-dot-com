package com.gooner.dhaka.bhogatedotcom;

import com.gooner.dhaka.bhogatedotcom.util.JustMessingAround;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class BhogateDotComApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(BhogateDotComApplication.class, args);
        JustMessingAround bean = run.getBean(JustMessingAround.class);

        bean.logTheProperties();
    }
}
