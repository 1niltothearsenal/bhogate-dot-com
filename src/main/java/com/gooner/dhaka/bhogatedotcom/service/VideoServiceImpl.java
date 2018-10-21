package com.gooner.dhaka.bhogatedotcom.service;

import com.gooner.dhaka.bhogatedotcom.controller.VideoController;
import com.gooner.dhaka.bhogatedotcom.dao.VideoDao;
import com.gooner.dhaka.bhogatedotcom.exception.VideoNotFoundException;
import com.gooner.dhaka.bhogatedotcom.model.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.datastax.driver.core.utils.UUIDs;

import java.net.URI;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@Slf4j
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    public VideoServiceImpl() {
    }

    @Override
    public ResponseEntity<Object> createVideo(Video video) {
        video.setVideoId(UUIDs.timeBased());
        videoDao.createVideo(video);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(video.getVideoId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @Override
    public ResponseEntity<Object> updateVideo(Video video) {
        if(!exists(video.getVideoId())) {
            throw new VideoNotFoundException("The VideoId does not exist. Please try with existing id.");
        }else {
            videoDao.updateVideo(video);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                    buildAndExpand(video.getVideoId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }

    @Override
    public Resource<Video> getVideoById(UUID id) {

       /* if(!exists(id)) {
            throw new UserNotFoundException("The VideoId does not exist. Please try with existing id.");
        }else {

            Video video = videoDao.getVideoById(id);

            log.info(video.toString());

            Resource<Video> resource = new Resource<Video>(video);
            ControllerLinkBuilder linkTo = linkTo(methodOn(VideoController.class).findAllVideos());
            resource.add(linkTo.withRel("all-videos"));
            return resource;
        }*/

        Video video = videoDao.getVideoById(id);

        if(video == null){
            throw new VideoNotFoundException("The VideoId does not exist. Please try with existing id.");
        }

        log.info(video.toString());

        Resource<Video> resource = new Resource<Video>(video);
        ControllerLinkBuilder linkTo = linkTo(methodOn(VideoController.class).findAllVideos());
        resource.add(linkTo.withRel("all-videos"));
        return resource;


    }

    @Override
    public List<Video> getAllVideos() {
        return videoDao.getAllVideos();
    }

    @Override
    public ResponseEntity<Object> deleteVideoById(UUID id) {

        if(!exists(id)) {
            throw new VideoNotFoundException("The VideoId does not exist. Please try with existing id.");
        }else {
            videoDao.deleteVideoById(id);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("").
                    buildAndExpand().toUri();
           return ResponseEntity.ok(location);
        }

    }

    @Override
    public ResponseEntity<Object> deleteVideo(Video video) {
        if(!exists(video.getVideoId())) {
            throw new VideoNotFoundException("The Video does not exist. Please try with existing video.");
        }else {
            videoDao.deleteVideo(video);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                    buildAndExpand(video.getVideoId()).toUri();
            return ResponseEntity.ok(location);
        }
    }

    @Override
    public boolean exists(UUID id) {
        return videoDao.checkIfExists(id);
    }

}
