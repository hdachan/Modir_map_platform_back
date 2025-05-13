package com.example.modir.feed.like.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FeedLikeRes {
    private long feedId;
    @JsonIgnore
    private String uuid;
    private String username;
    private String title;
    private int hits; // 추가: 조회수
    private String createdAt; // 추가: 생성일
}