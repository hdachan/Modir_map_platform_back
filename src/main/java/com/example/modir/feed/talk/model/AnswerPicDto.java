package com.example.modir.feed.talk.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AnswerPicDto {
    private long answerId;
    private List<String> pics;
}
