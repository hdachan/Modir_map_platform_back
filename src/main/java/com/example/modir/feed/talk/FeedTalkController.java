package com.example.modir.feed.talk;


import com.example.modir.common.model.ResultResponse;
import com.example.modir.feed.model.PutFeedReq;
import com.example.modir.feed.talk.model.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("talk")
@RestController
public class FeedTalkController {
    private final FeedTalkService feedTalkService;

    @PostMapping("first-word")
    @Operation(summary = "환영 메시지 작성")
    public ResultResponse<Integer> postFeedTalkFirstWord(@RequestBody InsFeedTalkFirstWordReq req) {
        int result = feedTalkService.postFeedTalkFirstWord(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("환영 메시지 작성 완료")
                .resultData(result)
                .build();
    }

    @GetMapping("first-word")
    @Operation(summary = "환영 메시지 보기")
    public ResultResponse<List<SelFeedTalkFirstWordRes>> getFeedTalkFirstWord(@ParameterObject long feedId) {
        List<SelFeedTalkFirstWordRes> resList = feedTalkService.getFeedTalkFirstWord(feedId);

        return ResultResponse.<List<SelFeedTalkFirstWordRes>>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("환영 메시지 작성 완료")
                .resultData(resList)
                .build();
    }

    @PatchMapping("first_word")
    @Operation(summary = "환영 메시지 수정")
    public ResultResponse<Integer> putFeedTalkFirstWord(@RequestBody UpdFeedTalkFirstWordReq req) {
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
    
    @PostMapping("category")
    @Operation(summary = "카테고리 등록")
    public ResultResponse<Integer> postFeedTalkCategory(@RequestBody InsTalkCategoryReq req) {
        int result = feedTalkService.postTalkCategory(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("카테고리 등록 완료")
                .resultData(result)
                .build();
    }

    @GetMapping("category")
    @Operation(summary = "카테고리 보기")
    public ResultResponse<List<SelTalkCategoryRes>> getFeedTalkCategory(@ParameterObject long feedId){
        List<SelTalkCategoryRes> resList = feedTalkService.getTalkCategory(feedId);

        return ResultResponse.<List<SelTalkCategoryRes>>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("카테고리 보기 완료")
                .resultData(resList)
                .build();
    }

    @PatchMapping("category")
    @Operation(summary = "카테고리 수정")
    public ResultResponse<Integer> putTalkCategory(@RequestBody UpdTalkCategoryReq req) {
        int result = feedTalkService.putTalkCategory(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("카테고리 수정 완료")
                .resultData(result)
                .build();
    }

    @DeleteMapping("category")
    @Operation(summary = "카테고리 삭제")
    public ResultResponse<Integer> delTalkCategory(DelTalkCategoryReq req) {
        int result = feedTalkService.delTalkCategory(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("카테고리 삭제 완료")
                .resultData(result)
                .build();
    }

    @PostMapping("result")
    @Operation(summary = "결과 등록")
    public ResultResponse<InsAnswerRes> postAnswer(@RequestPart(required = false) List<MultipartFile> pics,
                                                   @RequestParam(required = false) String result,
                                                   @RequestPart("req") InsAnswerReq req) {

        InsAnswerRes res = feedTalkService.insAnswer(req, pics, result  );

        return ResultResponse.<InsAnswerRes>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("결과 등록 완료")
                .resultData(res)
                .build();
    }

    @GetMapping("result")
    @Operation(summary = "결과 확인")
    public ResultResponse<List<SelAnswerResultRes>> getAnswerResult(@ParameterObject long categoryId) {
        List<SelAnswerResultRes> resList = feedTalkService.getAnswerResult(categoryId);

        return ResultResponse.<List<SelAnswerResultRes>>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("결과 등록 완료")
                .resultData(resList)
                .build();
    }

    @DeleteMapping("result")
    @Operation(summary = "결과 삭제")
    public ResultResponse<Integer> delAnswerResult(long answerId) {
        int result = feedTalkService.delAnswerResult(answerId);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("카테고리 삭제 완료")
                .resultData(result)
                .build();
    }
}
