package com.example.modir.feed.talk.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InsAnswerPicReq {
    private long answerId;
    private List<String> pics;
}
