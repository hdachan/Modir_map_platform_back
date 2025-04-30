package com.example.modir.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class SelFeedDetailRes {
    @JsonIgnore
    private String uuid;
    private int isAuthor;
    private String username;
    private String title;
    private String content;
    private String email;
    private int hits;
    private String createdAt;
    private int sumLike;
    private int status;

    List<String> pic;

}
