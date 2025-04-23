package com.example.modir.feed.like;


import com.example.modir.common.model.ResultResponse;
import com.example.modir.feed.like.model.FeedLikeReq;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("like")

public class FeedLikeController {
    private final FeedLikeService feedLikeService;

    @GetMapping
    public ResultResponse<Integer> feedLike(@ParameterObject FeedLikeReq req) {
        int result = feedLikeService.FeedLike(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage(result == 0 ? "좋아요 취소": "좋아요 등록")
                .resultData(result)
                .build();
    }
}
