package com.example.modir.feed;

import com.example.modir.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


// int 로 하면도미 cud는 프론트로 던지는게 아니기 때문에
// r는 받은걸 기준으로 보여줘야되니까 list로
@Mapper
public interface FeedMapper {
    int insFeed(InsFeedReq req);
    List<selFeedRes> selFeed();
    SelFeedDetailRes selFeedDetail(SelFeedDetailReq req);
    int updFeed(UpdFeedReq req);
    int delFeed(long feedId);
    int updFeedHits(long feedId);
    int insFeedHits(SelFeedDetailReq req);
}
