package com.example.modir.feed;


import com.example.modir.common.model.ResultResponse;
import com.example.modir.feed.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("feed")
public class FeedController {
    private final FeedService feedService;

    @PostMapping
    @Operation(summary = "킴우준병신")
    public ResultResponse<Integer> postFeed(InsFeedReq req){
        int result = feedService.postFeed(req);

        return ResultResponse.<Integer>builder()
                .resultMessage("피드 등록 완료")
                .resultData(result)
                .build();
    }

    @GetMapping
    @Operation(summary = "게시글 전체조회")
    public ResultResponse<List<selFeedRes>> getFeed(){
        List<selFeedRes> res = feedService.getFeed();

        return ResultResponse.<List<selFeedRes>>builder()
                .resultMessage("게시글 전체 조회 완료")
                .resultData(res)
                .build();
    }

    @GetMapping("/detail")
    @Operation(summary = "게시글 상세 조회")
    public ResultResponse<SelFeedDetailRes> getFeedDetail(SelFeedDetailReq req){
        SelFeedDetailRes res = feedService.getFeedDetail(req);

        return ResultResponse.<SelFeedDetailRes>builder()
                .resultMessage("게시글 상세조회 완료")
                .resultData(res)
                .build();

    }

    @PutMapping
    @Operation(summary = "게시글 수정")
    public ResultResponse<Integer> putFeed(@RequestBody UpdFeedReq req){
        int result = feedService.putFeed(req);

        return ResultResponse.<Integer>builder()
                .resultMessage("게시글 수정 완료")
                .resultData(result)
                .build();

    }

    @PutMapping("/delete")
    @Operation(summary = "게시글 숨김 처리")
    public ResultResponse<Integer> delFeed(@RequestBody long feedId){
        int result = feedService.delFeed(feedId);

        return ResultResponse.<Integer>builder()
                .resultMessage("게시글 삭제 완료")
                .resultData(result)
                .build();
    }
}
