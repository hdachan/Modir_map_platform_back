package com.example.modir.feed;


import com.example.modir.common.model.ResultResponse;
import com.example.modir.feed.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("feed")
public class FeedController {
    private final FeedService feedService;

    @PostMapping
    @Operation(summary = "게시글 등록")
    //Spring이 JSON을 파라미터로 매핑하지 못해서 오류가 나는 거야. JSON으로 데이터 받을 땐 반드시 @RequestBody 붙여야 해!
    public ResultResponse<FeedPostRes> postFeed(@RequestPart(required = false)List<MultipartFile> pics
                                            ,@RequestPart InsFeedReq req){
        FeedPostRes result = feedService.postFeed(req, pics);

        return ResultResponse.<FeedPostRes>builder()
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

    }@PutMapping
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
