package com.gooner.dhaka.bhogatedotcom.service;

import com.gooner.dhaka.bhogatedotcom.model.Video;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.UUID;

public interface VideoService {

    ResponseEntity<Object> createVideo(Video video);

    ResponseEntity<Object> updateVideo(Video video);

    Resource<Video> getVideoById(UUID id);

    List<Video> getAllVideos();

    ResponseEntity<Object> deleteVideoById(UUID id);

    ResponseEntity<Object> deleteVideo(Video video);

    boolean exists(UUID id);

}
