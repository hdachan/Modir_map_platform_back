package com.example.modir.feed.comment;

import com.example.modir.feed.comment.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FeedCommentMapper {
    int insFeedComment(InsFeedCommentReq req);
    List<SelFeedCommentDto> selFeedComment(SelFeedCommentReq req);
    int updFeedComment(UpdFeedCommentReq req);
    int delFeedComment(DelFeedCommentReq req);
}
