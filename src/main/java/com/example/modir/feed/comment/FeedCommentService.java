package com.example.modir.feed.comment;

import com.example.modir.common.jwt.AuthenticationFacade;
import com.example.modir.feed.comment.model.InsFeedCommentReq;
import com.example.modir.feed.comment.model.SelFeedCommentDto;
import com.example.modir.feed.comment.model.SelFeedCommentReq;
import com.example.modir.feed.comment.model.SelFeedCommentRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper feedCommentMapper;
    private final AuthenticationFacade authenticationFacade;
    public int postFeedComment(InsFeedCommentReq req) {
        String signedUuid = authenticationFacade.getSignedUserUuid();
        req.setUuid(signedUuid);
        int result = feedCommentMapper.insFeedComment(req);

        return result;
    }

    public SelFeedCommentRes getSelFeedComment(SelFeedCommentReq req) {
        SelFeedCommentRes res = new SelFeedCommentRes();
        if(req.getStartIdx()<0){
            res.setCommentDto(new ArrayList<>());

            return res;
        }

        List<SelFeedCommentDto> dtoList = feedCommentMapper.selFeedComment(req);
        res.setCommentDto(dtoList);
        res.setMoreComment(dtoList.size()== req.getSize());

        if(res.isMoreComment()){
            dtoList.remove(dtoList.size()-1);
        }
        return res;
    }
}
