package com.gooner.dhaka.bhogatedotcom.service;

import com.gooner.dhaka.bhogatedotcom.dao.VideoDao;
import com.gooner.dhaka.bhogatedotcom.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoDao videoDao;

    public VideoServiceImpl() {
    }

    @Override
    public void createVideo(Video video) {
        videoDao.createVideo(video);
    }

    @Override
    public void updateVideo(Video video) {
        videoDao.updateVideo(video);
    }

    @Override
    public Video getVideo(UUID id) {
        return videoDao.getVideo(id);
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
