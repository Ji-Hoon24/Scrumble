package com.jh.scrumble.post.dto.response;

import com.jh.scrumble.post.dto.entity.PostDetail;
import com.jh.scrumble.post.dto.entity.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostsListResponseDto {

    private Posts posts;

    private List<PostDetail> postDetailList;

}
