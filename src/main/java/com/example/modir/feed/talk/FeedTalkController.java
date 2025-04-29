package com.example.modir.feed.talk;


import com.example.modir.common.model.ResultResponse;
import com.example.modir.feed.talk.model.DelFeedTalkFirstWordReq;
import com.example.modir.feed.talk.model.InsFeedTalkFirstWordReq;
import com.example.modir.feed.talk.model.SelFeedTalkFirstWordRes;
import com.example.modir.feed.talk.model.UpdFeedTalkFirstWordReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("talk")
@RestController
public class FeedTalkController {
    private final FeedTalkService feedTalkService;

    @PostMapping("first-word")
    @Operation(summary = "환영 메시지 작성")
    public ResultResponse<Integer> postFeedTalkFirstWord(InsFeedTalkFirstWordReq req) {
        int result = feedTalkService.postFeedTalkFirstWord(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("환영 메시지 작성 완료")
                .resultData(result)
                .build();
    }

    @GetMapping("first-word")
    @Operation(summary = "환영 메시지 보기")
    public ResultResponse<List<SelFeedTalkFirstWordRes>> getFeedTalkFirstWord(long feedId) {
        List<SelFeedTalkFirstWordRes> resList = feedTalkService.getFeedTalkFirstWord(feedId);

        return ResultResponse.<List<SelFeedTalkFirstWordRes>>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("환영 메시지 작성 완료")
                .resultData(resList)
                .build();
    }

    @PatchMapping("first_word")
    @Operation(summary = "환영 메시지 수정")
    public ResultResponse<Integer> putFeedTalkFirstWord(UpdFeedTalkFirstWordReq req) {
        int result = feedTalkService.putFeedTalkFirstWord(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("환영 메시지 수정 완료")
                .resultData(result)
                .build();
    }

    @DeleteMapping("first_word")
    @Operation(summary = "환영 메시지 삭제")
    public ResultResponse<Integer> delFeedTalkFirstWord(DelFeedTalkFirstWordReq req) {
        int result = feedTalkService.delFeedTalkFirstWord(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("환영 메시지 삭제 완료")
                .resultData(result)
                .build();
    }
}
