package com.gooner.dhaka.bhogatedotcom.model;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table("videos_by_tag_year")
public class VideosByTagYear {

    @PrimaryKeyColumn(name="tag",ordinal=0,type=PrimaryKeyType.PARTITIONED)
    private String tag;

    @PrimaryKeyColumn(name="added_value",ordinal=1,type=PrimaryKeyType
            .CLUSTERED,ordering=Ordering.DESCENDING)
    private Integer addedYear;

    @PrimaryKeyColumn(name="video_id",ordinal=2,type=PrimaryKeyType
            .CLUSTERED,ordering=Ordering.ASCENDING)
    private UUID videoId;

    @Column("added_date")
    private Date addedDate;

    @Column("description")
    private String description;

    @Column("title")
    private String title;

    @Column("user_id")
    private UUID userId;


    public VideosByTagYear(String tag, Integer addedYear, UUID videoId, Date addedDate, String description, String title, UUID userId) {
        this.tag = tag;
        this.addedYear = addedYear;
        this.videoId = videoId;
        this.addedDate = addedDate;
        this.description = description;
        this.title = title;
        this.userId = userId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getAddedYear() {
        return addedYear;
    }

    public void setAddedYear(Integer addedYear) {
        this.addedYear = addedYear;
    }

    public UUID getVideoId() {
        return videoId;
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
        return "VideosByTagYear{" +
                "tag='" + tag + '\'' +
                ", addedYear=" + addedYear +
                ", videoId=" + videoId +
                ", addedDate=" + addedDate +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                '}';
    }
}
