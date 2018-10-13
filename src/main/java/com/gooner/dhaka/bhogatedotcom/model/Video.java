package com.gooner.dhaka.bhogatedotcom.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.util.Date;
import java.util.UUID;

@Table("videos")
public class Video {

    @PrimaryKey("video_id")
    private UUID videoId;

    @Column("added_date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date addedDate;

    @Column("description")
    private String description;

    @Column("title")
    private String title;

    @Column("user_id")
    private UUID userId;

    public Video() {
    }

    public UUID getVideoId() {
        return videoId;
    }

    public Video(UUID videoId, Date addedDate, String description, String title, UUID userId) {
        this.videoId = videoId;
        this.addedDate = addedDate;
        this.description = description;
        this.title = title;
        this.userId = userId;
    }

    public void setVideoId(UUID videoId) {
        this.videoId = videoId;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoId=" + videoId +
                ", addedDate=" + addedDate +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                '}';
    }
}
