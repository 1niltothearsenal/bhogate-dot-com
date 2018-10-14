package com.gooner.dhaka.bhogatedotcom.controller;

import com.gooner.dhaka.bhogatedotcom.model.Video;
import com.gooner.dhaka.bhogatedotcom.service.VideoService;
import com.sun.jndi.toolkit.url.Uri;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.parser.Entity;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("cassandra")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("videos")
    public List<Video> searchVideos(){
        return videoService.getAllVideos();
    }

    @GetMapping("videos/{id}")
    public Video findById(@PathVariable("id")UUID id){
        return videoService.getVideo(id);
    }

    @PostMapping("videos")
    public ResponseEntity<Object> postVideos(@RequestBody Video video){

        videoService.createVideo(video);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(video.getUserId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("videos")
    public void updateVideo(@RequestBody Video video){
        videoService.updateVideo(video);
    }

    @DeleteMapping("videos")
    public void deleteVideos(@RequestBody Video video){
        videoService.deleteVideo(video);
    }

}
