package com.gooner.dhaka.bhogatedotcom.controller;

import com.gooner.dhaka.bhogatedotcom.model.Video;
import com.gooner.dhaka.bhogatedotcom.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("cassandra")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("videos")
    public List<Video> findAllVideos(){
        return videoService.getAllVideos();
    }

    @GetMapping("videos/{id}")
    public Resource<Video> findById(@PathVariable("id")UUID id){
        return videoService.getVideoById(id);
    }

    @PostMapping("videos")
    public ResponseEntity<Object> postVideos(@RequestBody Video video){
        return videoService.createVideo(video);
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
