package com.example.modir.feed.talk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsTalkCategoryReq {
    private long feedId;
    private String title;
    @JsonIgnore
    private String uuid;
}
