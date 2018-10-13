package com.gooner.dhaka.bhogatedotcom.service;

import com.gooner.dhaka.bhogatedotcom.model.Video;

import java.util.List;
import java.util.UUID;

public interface VideoService {

    public void createVideo(Video video);

    public Video getVideo(UUID id);

    public List<Video> getAllVideos();

}
