package com.example.modir.feed.talk;

import com.example.modir.feed.talk.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedTalkMapper {
    // 환영 메시지 부분
    int insFeedTalkFirstWord(InsFeedTalkFirstWordReq req);
    List<SelFeedTalkFirstWordRes> selFeedTalkFirstWord(long feedId);
    int updFeedTalkFirstWord(UpdFeedTalkFirstWordReq req);
    int delFeedTalkFirstWord(DelFeedTalkFirstWordReq req);

    // 카테고리 부분
    int insTalkCategory(InsTalkCategoryReq req);
    List<SelTalkCategoryRes> selTalkCategory(long feedId);
}
