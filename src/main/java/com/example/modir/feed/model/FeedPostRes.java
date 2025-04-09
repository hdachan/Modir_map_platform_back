package com.example.modir.feed.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FeedPostRes {
    private long FeedId;
    private List<String> pics;
}
