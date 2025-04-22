package com.example.modir.feed;


import com.example.modir.common.MyFileUtils;
import com.example.modir.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper feedMapper;
    private final MyFileUtils myFileUtils;
    private final FeedPicMapper feedPicMapper;

    public FeedPostRes postFeed(InsFeedReq req, List<MultipartFile> pics) {
        int result = feedMapper.insFeed(req); // 피드 생성

        long feedId = req.getFeedId(); // 피드 ID 가져오기

        String middlePath = String.format("feed/%d", feedId);
        myFileUtils.makeFolders(middlePath);

        List<String> picNameList = new ArrayList<>();
        // pics가 null이 아니고 비어있지 않을 때만 파일 처리
        if (pics != null && !pics.isEmpty()) {
            for (MultipartFile pic : pics) {
                String savePicName = myFileUtils.makeRandomFileName(pic);
                picNameList.add(savePicName);
                String filePath = String.format("%s/%s", middlePath, savePicName);

                try {
                    myFileUtils.transferTo(pic, filePath);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // 사진이 있을 경우에만 FeedPicDto 처리
            FeedPicDto feedPicDto = new FeedPicDto();
            feedPicDto.setFeedId(feedId);
            feedPicDto.setPics(picNameList);
            feedPicMapper.insFeedPic(feedPicDto);
        }

        FeedPostRes res = new FeedPostRes();
        res.setFeedId(feedId);
        res.setPics(picNameList); // 사진이 없으면 빈 리스트 반환

        return res;
    }

    public List<selFeedRes> getFeed() {
        List<selFeedRes> res = feedMapper.selFeed();

        return res;
    }

    public SelFeedDetailRes getFeedDetail(SelFeedDetailReq req) {
        SelFeedDetailRes res = feedMapper.selFeedDetail(req);

        long feedId = req.getFeedId();
        feedMapper.updFeedHits(feedId);
        feedMapper.insFeedHits(req);

        return res;
    }

    public int putFeed(UpdFeedReq req) {
        int result = feedMapper.updFeed(req);

        return result;
    }

    public int delFeed(long feedId) {
        int result = feedMapper.delFeed(feedId);

        return result;
    }
}
