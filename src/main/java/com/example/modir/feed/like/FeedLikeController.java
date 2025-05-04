package com.example.modir.feed.like;


import com.example.modir.common.jwt.AuthenticationFacade;
import com.example.modir.common.model.ResultResponse;
import com.example.modir.feed.like.model.FeedLikeReq;
import com.example.modir.feed.like.model.FeedLikeRes;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("like")
public class FeedLikeController {
    private final FeedLikeService feedLikeService;
    private final AuthenticationFacade authenticationFacade; // 이 줄이 반드시 필요!

    @GetMapping
    public ResultResponse<Integer> feedLike(@ParameterObject FeedLikeReq req) {
        int result = feedLikeService.FeedLike(req);

        return ResultResponse.<Integer>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage(result == 0 ? "좋아요 취소": "좋아요 등록")
                .resultData(result)
                .build();
    }



    @GetMapping("/my")
    public ResultResponse<List<FeedLikeRes>> getMyLikedFeeds() {
        String uuid = authenticationFacade.getSignedUserUuid();
        List<FeedLikeRes> likedFeeds = feedLikeService.getLikedFeeds(uuid);
        return ResultResponse.<List<FeedLikeRes>>builder()
                .statusCode(HttpStatus.OK.toString())
                .resultMessage("좋아요한 피드 목록 조회 성공")
                .resultData(likedFeeds)
                .build();
    }
}
