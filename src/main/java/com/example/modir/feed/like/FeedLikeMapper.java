package com.example.modir.feed.like;


import com.example.modir.feed.like.model.FeedLikeReq;
import com.example.modir.feed.like.model.FeedLikeRes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper


public interface FeedLikeMapper {
    int insFeedLike(FeedLikeReq req);
    int delFeedLike(FeedLikeReq req);
    List<FeedLikeRes> selectLikedFeedsByUuid(String uuid);
}
