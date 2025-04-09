package com.example.modir.feed;


import com.example.modir.feed.model.FeedPicDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedPicMapper {
    int insFeedPic(FeedPicDto p);
}
