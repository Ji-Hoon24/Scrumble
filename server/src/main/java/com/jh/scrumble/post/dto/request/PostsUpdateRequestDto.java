package com.jh.scrumble.post.dto.request;

import com.jh.scrumble.post.dto.entity.PostDetail;
import com.jh.scrumble.post.dto.entity.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.List;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private Posts posts;

    private List<PostDetail> postDetailList;

    @Builder
    public PostsUpdateRequestDto(Posts posts, List<PostDetail> postDetailList) {
        this.posts = posts;
        this.postDetailList = postDetailList;
    }
}
