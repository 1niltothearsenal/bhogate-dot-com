package com.gooner.dhaka.bhogatedotcom.controller;

import com.gooner.dhaka.bhogatedotcom.model.Video;
import com.gooner.dhaka.bhogatedotcom.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.jdt.core.compiler.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.InvalidEndpointRequestException;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
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

    @DeleteMapping({"videos","videos/{id}"})
    public ResponseEntity<Object> deleteVideosById(@PathVariable("id") Optional<UUID> videoId,
                                 @RequestBody Optional<Video> videoDetails){
        if (videoId.isPresent()) {
            return videoService.deleteVideoById(videoId.get());
        } else if(videoDetails.isPresent()){
            return videoService.deleteVideo(videoDetails.get());
        } else {
            throw new InvalidEndpointRequestException("Please check the request parameter","Wrong input format");
        }
    }

}
