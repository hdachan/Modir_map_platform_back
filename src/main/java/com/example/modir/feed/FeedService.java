package com.example.modir.feed;


import com.example.modir.common.MyFileUtils;
import com.example.modir.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper feedMapper;
    private final MyFileUtils myFileUtils;
    private final FeedPicMapper feedPicMapper;

    public FeedPostRes postFeed(InsFeedReq req, List<MultipartFile> pics) {
        int result = feedMapper.insFeed(req); // 생성하는거 피드 id

        long feedId = req.getFeedId(); //가져오는거


        String middlePath = String.format("feed/%d", feedId);
        myFileUtils.makeFolders(middlePath);

        List<String> picNameList = new ArrayList<>();
        for (MultipartFile pic: pics){
            String savePicName = myFileUtils.makeRandomFileName(pic);
            picNameList.add(savePicName);
            String filePath = String.format("%s/%s", middlePath, savePicName);

            try {
                myFileUtils.transferTo(pic , filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FeedPicDto feedPicDto = new FeedPicDto();
        feedPicDto.setFeedId(feedId);
        feedPicDto.setPics(picNameList);
        int resultPic =feedPicMapper.insFeedPic(feedPicDto);

        FeedPostRes res =new FeedPostRes();
        res.setFeedId(feedId);
        res.setPics(picNameList);

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
