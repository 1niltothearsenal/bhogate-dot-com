package com.gooner.dhaka.bhogatedotcom.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

@Configuration
public class ReadingFromAFile {

    @Autowired
    private Environment environment;

    @Autowired
    ResourceLoader resourceLoader;


    public String getJson() {

        try {

            String jsonFileName = environment.getProperty("cassandra.filename");

            Resource resource = resourceLoader.getResource("classpath:configure/" + jsonFileName);

            InputStream inputStream = resource.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            String collect = reader.lines().collect(Collectors.joining(System.lineSeparator()));

            inputStream.close();

            return collect;
        }catch (IOException ex){
            ex.printStackTrace();
            return null;
        }
    }


}
