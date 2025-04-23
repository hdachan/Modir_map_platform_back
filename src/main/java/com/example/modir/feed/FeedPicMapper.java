package com.example.modir.feed;


import com.example.modir.feed.model.FeedPicDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedPicMapper {
    int insFeedPic(FeedPicDto p);
    List<String> selFeedPicList(long feedId);
}
