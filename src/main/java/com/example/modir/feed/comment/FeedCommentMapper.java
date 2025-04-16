package com.example.modir.feed.comment;

import com.example.modir.feed.comment.model.InsFeedCommentReq;
import com.example.modir.feed.comment.model.SelFeedCommentDto;
import com.example.modir.feed.comment.model.SelFeedCommentReq;
import com.example.modir.feed.comment.model.SelFeedCommentRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FeedCommentMapper {
    int insFeedComment(InsFeedCommentReq req);

    List<SelFeedCommentDto> selFeedComment(SelFeedCommentReq req);
}
