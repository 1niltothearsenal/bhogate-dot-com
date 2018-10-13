package com.gooner.dhaka.bhogatedotcom.dao;

import com.gooner.dhaka.bhogatedotcom.model.Video;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VideoDao {

    public void createVideo(Video video);

    public Video getVideo(UUID videoId);

    public List<Video> getAllVideos();

}
