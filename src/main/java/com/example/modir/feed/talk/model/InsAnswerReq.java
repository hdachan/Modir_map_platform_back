package com.example.modir.feed.talk.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InsAnswerReq {
    private long categoryId;
    @JsonIgnore
    private long answerId;
}
