package com.example.modir.feed.comment.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SelFeedCommentRes {
    private boolean moreComment;
    private List<SelFeedCommentDto> commentDto;
}
