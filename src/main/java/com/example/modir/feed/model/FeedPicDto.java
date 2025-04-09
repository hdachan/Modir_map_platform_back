package com.example.modir.feed.model;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class FeedPicDto {
    private long feedId;
    private List<String> pics;
}
