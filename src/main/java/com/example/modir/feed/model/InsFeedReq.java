package com.example.modir.feed.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class InsFeedReq {
    @JsonIgnore //  숨기는거 스웨거 상에서 피드아이디를 안보이게 숨김
    private long feedId;
    private String title;
    private String content;
    private String uuid;
}
