package com.jh.scrumble.post.service;

import com.jh.scrumble.post.domain.PostDetailRepository;
import com.jh.scrumble.post.dto.entity.PostDetail;
import com.jh.scrumble.post.dto.request.PostsSaveRequestDto;
import com.jh.scrumble.post.dto.request.PostsUpdateRequestDto;
import com.jh.scrumble.post.dto.entity.Posts;
import com.jh.scrumble.post.domain.PostsRepository;
import com.jh.scrumble.post.dto.response.PostsListResponseDto;
import com.jh.scrumble.post.dto.response.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final PostDetailRepository postDetailRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        Long postId = postsRepository.save(requestDto.getPosts()).getId();
        for(PostDetail postDetail : requestDto.getPostDetailList()) {
            postDetail.setId(postId);
            postDetailRepository.save(postDetail);
        }

        return postId;
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.save(requestDto.getPosts());
        postDetailRepository.saveAll(requestDto.getPostDetailList());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        List<PostDetail> postDetailList = postDetailRepository.findAllById(id);
        return new PostsResponseDto(posts, postDetailList);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postDetailRepository.deleteAllById(id);
        postsRepository.delete(posts);
    }
}
