package com.example.modir.feed.like.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class FeedLikeReq {
    private long feedId;
    @JsonIgnore
    private String uuid;
}
