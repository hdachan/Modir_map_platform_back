package com.example.modir.feed.like;


import com.example.modir.common.jwt.AuthenticationFacade;
import com.example.modir.feed.like.model.FeedLikeReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class FeedLikeService {
    private final FeedLikeMapper feedLikeMapper;
    private final AuthenticationFacade authenticationFacade;

    public int FeedLike(FeedLikeReq req){
        String signed = authenticationFacade.getSignedUserUuid();
        req.setUuid(signed);

        int result = feedLikeMapper.delFeedLike(req);
        if(result == 0){  //영향받은게 없으면 인썰트해라
            return feedLikeMapper.insFeedLike(req);
        }

        return 0;
    }
}
