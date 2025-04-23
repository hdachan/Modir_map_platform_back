package com.example.modir.feed.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdFeedCommentReq {
    private String content;
    private long commentId;
    @JsonIgnore
    private String uuid;
}
