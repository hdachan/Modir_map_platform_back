package com.example.modir.feed.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


// res 백엔드가주는거 req가 프론트한테 받는거
public class selFeedRes {

    private long feedId;
    private String username;
    private String title;
    private String content;
    private int hits;
    private String createdAt;
    private int sumLike;
}
