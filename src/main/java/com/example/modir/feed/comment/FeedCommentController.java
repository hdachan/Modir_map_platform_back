package com.example.modir.feed.comment;


import com.example.modir.common.model.ResultResponse;
import com.example.modir.feed.comment.model.InsFeedCommentReq;
import com.example.modir.feed.comment.model.SelFeedCommentDto;
import com.example.modir.feed.comment.model.SelFeedCommentReq;
import com.example.modir.feed.comment.model.SelFeedCommentRes;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("comment")
public class FeedCommentController {

    private final FeedCommentService feedCommentService;

    @PostMapping
    public ResultResponse<Integer> postFeedComment(@RequestBody InsFeedCommentReq req) {
        int result = feedCommentService.postFeedComment(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("댓글 작성 완료")
                .resultData(result)
                .build();
    }

    @GetMapping
    public ResultResponse<SelFeedCommentRes> getFeedComments(@ParameterObject SelFeedCommentReq req) {
        SelFeedCommentRes res = feedCommentService.getSelFeedComment(req);


        return ResultResponse.<SelFeedCommentRes>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("댓글 보여주기 ")
                .resultData(res)
                .build();
    }
}
