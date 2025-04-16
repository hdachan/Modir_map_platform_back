package com.example.modir.feed.comment.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsFeedCommentReq {

    private long feedId;
    private long uuid;
    private String content;
}
