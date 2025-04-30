package com.example.modir.feed.talk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdTalkCategoryReq {
    private String title;
    private long categoryId;
    @JsonIgnore
    private String uuid;
}
