package com.example.modir.feed.comment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelFeedCommentCommentRes {
    private long commentId;
    private String username;
    private String content;
    private String createdAt;
}
