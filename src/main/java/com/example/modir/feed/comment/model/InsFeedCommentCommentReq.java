package com.example.modir.feed.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsFeedCommentCommentReq {
    private long feedId;
    private long parentCommentId;
    @JsonIgnore
    private String uuid;
    private String content;
}
