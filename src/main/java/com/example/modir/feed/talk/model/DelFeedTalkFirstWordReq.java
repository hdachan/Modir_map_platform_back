package com.example.modir.feed.talk.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DelFeedTalkFirstWordReq {
    private long firstWordId;
    @JsonIgnore
    private String uuid;
}
