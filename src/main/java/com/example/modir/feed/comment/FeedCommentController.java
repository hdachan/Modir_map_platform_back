package com.example.modir.feed.comment;


import com.example.modir.common.model.ResultResponse;
import com.example.modir.feed.comment.model.*;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "댓글 등록")
    public ResultResponse<Integer> postFeedComment(@RequestBody InsFeedCommentReq req) {
        int result = feedCommentService.postFeedComment(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("댓글 작성 완료")
                .resultData(result)
                .build();
    }

    @GetMapping
    @Operation(summary = "댓글 조회")
    public ResultResponse<SelFeedCommentRes> getFeedComments(@ParameterObject SelFeedCommentReq req) {
        SelFeedCommentRes res = feedCommentService.getSelFeedComment(req);


        return ResultResponse.<SelFeedCommentRes>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("댓글 보여주기 ")
                .resultData(res)
                .build();
    }

    @PatchMapping
    @Operation(summary = "댓글 수정")
    public ResultResponse<Integer> putFeedComment(@RequestBody UpdFeedCommentReq req) {
        int result = feedCommentService.updFeedComment(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("댓글 수정 완료")
                .resultData(result)
                .build();
    }

    @PatchMapping("delete")
    @Operation(summary = "댓글 삭제")
    public ResultResponse<Integer> delFeedComment(@RequestBody DelFeedCommentReq req) {
        int result = feedCommentService.delFeedComment(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("댓글 삭제 완료")
                .resultData(result)
                .build();
    }
}
