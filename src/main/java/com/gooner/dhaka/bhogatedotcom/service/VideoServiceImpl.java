package com.gooner.dhaka.bhogatedotcom.service;

import com.gooner.dhaka.bhogatedotcom.controller.VideoController;
import com.gooner.dhaka.bhogatedotcom.dao.VideoDao;
import com.gooner.dhaka.bhogatedotcom.exception.UserNotFoundException;
import com.gooner.dhaka.bhogatedotcom.model.Video;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
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
        videoDao.createVideo(video);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
                buildAndExpand(video.getVideoId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @Override
    public void updateVideo(Video video) {
        videoDao.updateVideo(video);
    }

    @Override
    public Resource<Video> getVideoById(UUID id) {

        Video video = videoDao.getVideoById(id);

        log.info(video.toString());

        if(video == null) {
            throw new UserNotFoundException("Invalid User Id!!!" + id);
        }

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
    public void deleteVideo(Video video) {
        videoDao.deleteVideos(video);
    }
}
