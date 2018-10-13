package com.gooner.dhaka.bhogatedotcom.controller;

import com.gooner.dhaka.bhogatedotcom.model.Video;
import com.gooner.dhaka.bhogatedotcom.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("cassandra")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("get-videos")
    public List<Video> searchVideos(){
        return videoService.getAllVideos();
    }

    @GetMapping("get-videos/{id}")
    public Video findById(@PathVariable("id")UUID id){
        return videoService.getVideo(id);
    }

    @PostMapping("/video")
    public void postVideos(@RequestBody Video video){

        videoService.createVideo(video);

    }

}
