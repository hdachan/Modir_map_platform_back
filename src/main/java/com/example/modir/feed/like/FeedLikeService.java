package com.example.modir.feed.like;


import com.example.modir.feed.like.model.FeedLikeReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class FeedLikeService {
    private final FeedLikeMapper feedLikeMapper;

    public int FeedLike(FeedLikeReq req){
        int result = feedLikeMapper.delFeedLike(req);
        if(result == 0){  //영향받은게 없으면 인썰트해라
            return feedLikeMapper.insFeedLike(req);
        }

        return 0;
    }
}
