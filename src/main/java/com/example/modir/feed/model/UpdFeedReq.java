package com.example.modir.feed.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdFeedReq {
    private String title;
    private String content;
    private long feedId;
}
