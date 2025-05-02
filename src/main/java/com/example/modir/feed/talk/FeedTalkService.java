package com.example.modir.feed.talk;


import com.example.modir.common.MyFileUtils;
import com.example.modir.common.excprion.CustomException;
import com.example.modir.common.jwt.AuthenticationFacade;
import com.example.modir.feed.talk.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FeedTalkService {
    private final FeedTalkMapper feedTalkMapper;
    private final AuthenticationFacade authenticationFacade;
    private final MyFileUtils myFileUtils;

    public int postFeedTalkFirstWord(InsFeedTalkFirstWordReq req){
        String signedUuid = authenticationFacade.getSignedUserUuid();
        req.setUuid(signedUuid);

        if(signedUuid == null){
            throw new CustomException("로그인 후 사용해주세요", HttpStatus.BAD_REQUEST);
        }

        int result = feedTalkMapper.insFeedTalkFirstWord(req);

        return result;
    }

    public List<SelFeedTalkFirstWordRes> getFeedTalkFirstWord(long feedId){
        List<SelFeedTalkFirstWordRes> resList = feedTalkMapper.selFeedTalkFirstWord(feedId);

        return resList;
    }

    public int putFeedTalkFirstWord(UpdFeedTalkFirstWordReq req){
        String signedUuid = authenticationFacade.getSignedUserUuid();
        req.setUuid(signedUuid);

        if(signedUuid == null){
            throw new CustomException("로그인 후 사용해주세요", HttpStatus.BAD_REQUEST);
        }

        int result = feedTalkMapper.updFeedTalkFirstWord(req);

        return result;
    }

    public int delFeedTalkFirstWord(DelFeedTalkFirstWordReq req){
        String signedUuid = authenticationFacade.getSignedUserUuid();
        req.setUuid(signedUuid);

        if(signedUuid == null){
            throw new CustomException("로그인 후 사용해주세요", HttpStatus.BAD_REQUEST);
        }

        int result = feedTalkMapper.delFeedTalkFirstWord(req);

        return result;
    }

    public int postTalkCategory(InsTalkCategoryReq req){
        String signedUuid = authenticationFacade.getSignedUserUuid();
        req.setUuid(signedUuid);

        if(signedUuid == null){
            throw new CustomException("로그인 후 사용해주세요", HttpStatus.BAD_REQUEST);
        }

        int result = feedTalkMapper.insTalkCategory(req);

        return result;
    }

    public List<SelTalkCategoryRes> getTalkCategory(long feedId){
        List<SelTalkCategoryRes> resList = feedTalkMapper.selTalkCategory(feedId);

        return resList;
    }

    public int putTalkCategory(UpdTalkCategoryReq req){
        String signedUuid = authenticationFacade.getSignedUserUuid();
        req.setUuid(signedUuid);

        if(signedUuid == null){
            throw new CustomException("로그인 후 사용해주세요", HttpStatus.BAD_REQUEST);
        }

        int result = feedTalkMapper.updTalkCategory(req);

        return result;

    }

    public int delTalkCategory(DelTalkCategoryReq req){
        String signedUuid = authenticationFacade.getSignedUserUuid();
        req.setUuid(signedUuid);

        if(signedUuid == null){
            throw new CustomException("로그인 후 사용해주세요", HttpStatus.BAD_REQUEST);
        }

        int result = feedTalkMapper.delTalkCategory(req);

        return result;
    }

    @Transactional
    public InsAnswerRes insAnswer(InsAnswerReq req, List<MultipartFile> pics, String result){
        int row = feedTalkMapper.insTalkAnswer(req);

        if(row == 0){
            throw new CustomException("잘못된 접근입니다.", HttpStatus.BAD_REQUEST);
        }

        long answerId = req.getAnswerId(); // 피드 ID 가져오기


        List<String> picNameList = new ArrayList<>();
        // pics가 null이 아니고 비어있지 않을 때만 파일 처리
        if (pics != null && !pics.isEmpty()) {
            String middlePath = String.format("answer/%d", answerId);
            myFileUtils.makeFolders(middlePath);
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
            AnswerPicDto answerPicDto = new AnswerPicDto();
            answerPicDto.setAnswerId(answerId);
            answerPicDto.setPics(picNameList);
            feedTalkMapper.insAnswerPic(answerPicDto);
        }
        if(result != null){
            feedTalkMapper.insAnswerResult(req.getAnswerId(), result);
        }

        InsAnswerRes res = new InsAnswerRes();
        res.setAnswerId(answerId);
        res.setPics(picNameList);

        return res;
    }

    public List<SelAnswerResultRes> getAnswerResult(long categoryId){
        List<SelAnswerResultRes> resList = feedTalkMapper.selAnswerResult(categoryId);

        return resList;
    }

    public int delAnswerResult(long answerId){
        int result = feedTalkMapper.delAnswerResult(answerId);

        String deletePath = String.format("%s/answer/%s", myFileUtils.getUploadPath(), answerId);
        myFileUtils.deleteFolder(deletePath, true);

        return result;
    }
}
