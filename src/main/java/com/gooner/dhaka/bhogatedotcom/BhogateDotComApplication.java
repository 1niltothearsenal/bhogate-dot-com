package com.gooner.dhaka.bhogatedotcom;

import com.gooner.dhaka.bhogatedotcom.util.PropertyReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BhogateDotComApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(BhogateDotComApplication.class, args);

        PropertyReader bean = run.getBean(PropertyReader.class);

        bean.logMethod();

    }
}
