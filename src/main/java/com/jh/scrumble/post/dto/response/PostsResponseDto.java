package com.jh.scrumble.post.dto.response;

import com.jh.scrumble.post.dto.entity.PostDetail;
import com.jh.scrumble.post.dto.entity.Posts;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsResponseDto {

    private Posts posts;

    private List<PostDetail> postDetailList;

    public PostsResponseDto(Posts posts, List<PostDetail> postDetailList) {
        this.posts = posts;
        this.postDetailList = postDetailList;
    }

}
