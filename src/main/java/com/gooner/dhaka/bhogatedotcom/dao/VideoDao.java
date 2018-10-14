package com.gooner.dhaka.bhogatedotcom.dao;

import com.gooner.dhaka.bhogatedotcom.model.Video;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VideoDao {

    void createVideo(Video video);

    Video getVideoById(UUID videoId);

    void updateVideo(Video video);

    List<Video> getAllVideos();

    void deleteVideos(Video video);

}
