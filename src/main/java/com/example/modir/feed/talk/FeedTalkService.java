package com.example.modir.feed.talk;


import com.example.modir.common.excprion.CustomException;
import com.example.modir.common.jwt.AuthenticationFacade;
import com.example.modir.feed.talk.model.DelFeedTalkFirstWordReq;
import com.example.modir.feed.talk.model.InsFeedTalkFirstWordReq;
import com.example.modir.feed.talk.model.SelFeedTalkFirstWordRes;
import com.example.modir.feed.talk.model.UpdFeedTalkFirstWordReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedTalkService {
    private final FeedTalkMapper feedTalkMapper;
    private final AuthenticationFacade authenticationFacade;

    public int postFeedTalkFirstWord(InsFeedTalkFirstWordReq req){
        String signedUuid = authenticationFacade.getSignedUserUuid();
        req.setUuid(signedUuid);

        if(signedUuid == null){
            throw new CustomException("로그인 후 사용해주세요", HttpStatus.BAD_REQUEST);
        }

        int result = feedTalkMapper.insFeedTalkFirstWord(req);

        return result;
    }

    public List<SelFeedTalkFirstWordRes> getFeedTalkFirstWord(long feedId){
        List<SelFeedTalkFirstWordRes> resList = feedTalkMapper.selFeedTalkFirstWord(feedId);

        return resList;
    }

    public int putFeedTalkFirstWord(UpdFeedTalkFirstWordReq req){
        String signedUuid = authenticationFacade.getSignedUserUuid();
        req.setUuid(signedUuid);

        if(signedUuid == null){
            throw new CustomException("로그인 후 사용해주세요", HttpStatus.BAD_REQUEST);
        }

        int result = feedTalkMapper.updFeedTalkFirstWord(req);

        return result;
    }

    public int delFeedTalkFirstWord(DelFeedTalkFirstWordReq req){
        String signedUuid = authenticationFacade.getSignedUserUuid();
        req.setUuid(signedUuid);

        if(signedUuid == null){
            throw new CustomException("로그인 후 사용해주세요", HttpStatus.BAD_REQUEST);
        }

        int result = feedTalkMapper.delFeedTalkFirstWord(req);

        return result;
    }
}
