package com.example.modir.feed.comment.model;


import com.example.modir.common.Constants;
import lombok.Getter;

@Getter
public class SelFeedCommentReq {
    private long feedId;


    private int startIdx;
    private int size;

    public SelFeedCommentReq(long feedId, int startIdx, Integer size) {
        this.feedId = feedId;
        this.startIdx = startIdx;
        this.size = (size == null ? Constants.getDefault_page_size() : size) +1;
    }
}
