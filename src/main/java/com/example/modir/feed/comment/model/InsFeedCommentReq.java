package com.example.modir.feed.comment.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsFeedCommentReq {

    private long feedId;
    @JsonIgnore
    private String uuid;
    private String content;
}
