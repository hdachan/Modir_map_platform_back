package com.example.modir.feed.talk;

import com.example.modir.feed.talk.model.DelFeedTalkFirstWordReq;
import com.example.modir.feed.talk.model.InsFeedTalkFirstWordReq;
import com.example.modir.feed.talk.model.SelFeedTalkFirstWordRes;
import com.example.modir.feed.talk.model.UpdFeedTalkFirstWordReq;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedTalkMapper {
    int insFeedTalkFirstWord(InsFeedTalkFirstWordReq req);
    List<SelFeedTalkFirstWordRes> selFeedTalkFirstWord(long feedId);
    int updFeedTalkFirstWord(UpdFeedTalkFirstWordReq req);
    int delFeedTalkFirstWord(DelFeedTalkFirstWordReq req);
}
