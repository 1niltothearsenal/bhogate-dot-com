package com.gooner.dhaka.bhogatedotcom.dao;

import com.gooner.dhaka.bhogatedotcom.model.Video;
import com.gooner.dhaka.bhogatedotcom.repo.MyCassandraTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class VideoDaoImpl implements VideoDao {

    @Autowired
    private MyCassandraTemplate myCassandraTemplate;

    @Override
    public void createVideo(Video video) {
        myCassandraTemplate.create(video);
    }

    @Override
    public void updateVideo(Video video) {
        myCassandraTemplate.updateVideo(video,Video.class);
    }

    @Override
    public Video getVideoById(UUID videoId) {
        return myCassandraTemplate.findById(videoId,Video.class);
    }

    @Override
    public List<Video> getAllVideos() {
        return myCassandraTemplate.findAll(Video.class);
    }

    @Override
    public boolean deleteVideoById(UUID videoId) {
        return myCassandraTemplate.deleteVideoById(videoId,Video.class);
    }

    @Override
    public void deleteVideo(Video video) {
        myCassandraTemplate.deleteVideo(video);
    }

    @Override
    public boolean checkIfExists(UUID videoId) {
        return myCassandraTemplate.checkIfExistsById(videoId,Video.class);
    }
}
