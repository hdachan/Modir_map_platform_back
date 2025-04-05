package com.example.modir.feed;


import com.example.modir.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper feedMapper;

    public int postFeed(InsFeedReq req) {
        int result = feedMapper.insFeed(req);
        return result;
    }

    public List<selFeedRes> getFeed() {
        List<selFeedRes> res = feedMapper.selFeed();

        return res;
    }

    public SelFeedDetailRes getFeedDetail(SelFeedDetailReq req) {
        SelFeedDetailRes res = feedMapper.selFeedDetail(req);

        return res;
    }

    public int putFeed(UpdFeedReq req) {
        int result = feedMapper.updFeed(req);

        return result;
    }

    public int delFeed(long feedId) {
        int result = feedMapper.delFeed(feedId);

        return result;
    }
}
