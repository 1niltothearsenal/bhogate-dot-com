package com.gooner.dhaka.bhogatedotcom.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gooner.dhaka.bhogatedotcom.BhogateDotComApplication;
import com.gooner.dhaka.bhogatedotcom.model.Video;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BhogateDotComApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VideoControllerIntegrationTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testFindById() throws JSONException {
        HttpEntity<String> entity = new HttpEntity<String>(null,headers);

        ResponseEntity<String> response = restTemplate.exchange(
          createURLWithPort("/cassandra/videos/1645ea59-14bd-12e5-a993-0928354b7e31"),
          HttpMethod.GET, entity, String.class);

        String expected = "{\n" +
                "    \"videoId\": \"1645ea59-14bd-12e5-a993-0928354b7e31\",\n" +
                "    \"addedDate\": \"2018-04-03T00:00:00.000+0000\",\n" +
                "    \"description\": \"Best Nepali Movie\",\n" +
                "    \"title\": \"The Dark Knight & No Taxi Driver\",\n" +
                "    \"userId\": \"6546f8be-14bd-11e5-af1a-8638355b8e3a\",\n" +
                "    \"_links\": {\n" +
                "        \"all-videos\": {\n" +
                "            \"href\": \"http://localhost:"+port+"/cassandra/videos\"\n" +
                "        }\n" +
                "    }\n" +
                "}";

        JSONAssert.assertEquals(expected, response.getBody(),false);
    }

    @Test
    public void testPostVideos() throws IOException {
        String body = "{\n" +
                "        \"videoId\": \"2245ea59-14bd-12e5-a883-0928354b7e31\",\n" +
                "        \"addedDate\": \"2018-05-03T00:00:00.000+0000\",\n" +
                "        \"description\": \"Best Nepali Movie Part 2\",\n" +
                "        \"title\": \"The Dark Knight & No Taxi Driver in Nepal\",\n" +
                "        \"userId\": \"6546f8be-14bd-11e5-af1a-8638355b8e3a\"\n" +
                "    }";

        Video video = new ObjectMapper().readValue(body, Video.class);

        HttpEntity<Video> entity = new HttpEntity<Video>(video,headers);

/**
 *      URI uri = restTemplate.postForLocation(createURLWithPort("/cassandra/videos"), httpEntity);
 *      String expected = "http://localhost:"+port+"/cassandra/videos/2245ea59-14bd-12e5-a883-0928354b7e31";
 *      assertEquals(expected, uri.toString());
 */
        ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/cassandra/videos"),
                HttpMethod.POST, entity, String.class);
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        log.info(actual);
        assertFalse(actual.contains("/cassandra/videos/2245ea59-14bd-12e5-a883-0928354b7e31"));

    }

    private String createURLWithPort(String uri){
        return "http://localhost:"+ port + uri;

    }

}
