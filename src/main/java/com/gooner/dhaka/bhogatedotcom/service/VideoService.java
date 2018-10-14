package com.gooner.dhaka.bhogatedotcom.service;

import com.gooner.dhaka.bhogatedotcom.model.Video;

import java.util.List;
import java.util.UUID;

public interface VideoService {

    void createVideo(Video video);

    void updateVideo(Video video);

    Video getVideo(UUID id);

    List<Video> getAllVideos();

    void deleteVideo(Video video);

}
