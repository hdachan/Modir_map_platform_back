package com.example.modir.feed.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SelFeedDetailRes {
    private String username;
    private String title;
    private String content;
    private int hits;
    private String createdAt;
}
