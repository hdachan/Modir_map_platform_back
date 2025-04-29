package com.example.modir.feed.talk.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdFeedTalkFirstWordReq {
    private long firstWordId;
    private String word;
    @JsonIgnore
    private String uuid;
}
