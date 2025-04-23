package com.example.modir.feed.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class SelFeedDetailReq {
    private long feedId;
    @JsonIgnore
    private String uuid;
}
