package com.jh.scrumble.post.service;

import com.jh.scrumble.post.domain.PostDetailRepository;
import com.jh.scrumble.post.dto.entity.PostDetail;
import com.jh.scrumble.post.dto.request.PostsSaveRequestDto;
import com.jh.scrumble.post.dto.request.PostsUpdateRequestDto;
import com.jh.scrumble.post.dto.entity.Posts;
import com.jh.scrumble.post.domain.PostsRepository;
import com.jh.scrumble.post.dto.response.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postDetailRepository.deleteAllById(id);
        postsRepository.delete(posts);
    }

    public List<PostsResponseDto> postsList(Long page) {
        List<PostsResponseDto> result = new ArrayList<PostsResponseDto>();
        List<Posts> postsList = postsRepository.findTop10ByPage(page);
        for(Posts posts : postsList) {
            List<PostDetail> postDetailList = postDetailRepository.findAllById(posts.getId());
            PostsResponseDto dto = new PostsResponseDto(posts, postDetailList);
            result.add(dto);
        }
        return result;
    }
}
