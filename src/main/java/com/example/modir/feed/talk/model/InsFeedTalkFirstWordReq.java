package com.example.modir.feed.talk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsFeedTalkFirstWordReq {
    private long feedId;
    private String word;
    private int sequence;
    @JsonIgnore
    private String uuid;
}
