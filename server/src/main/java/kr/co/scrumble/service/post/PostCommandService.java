package kr.co.scrumble.service.post;

import kr.co.scrumble.dto.model.PostDetailDto;
import kr.co.scrumble.dto.request.PostRequestDto;
import kr.co.scrumble.dto.result.PostResultDto;
import kr.co.scrumble.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostCommandService {

    @Autowired
    PostMapper postMapper;

    public void addPost(PostRequestDto postRequestDto) {
        //TODO 로그인 구현 후 세션에서 유저 정보 데이터 추가
        postMapper.insertPost(postRequestDto.getPostDto());
        for(PostDetailDto postDetailDto : postRequestDto.getPostDetailDtoList()) {
            Long postId = postRequestDto.getPostDto().getPostId();
            postDetailDto.setPostId(postId);
            postMapper.insertPostDetail(postDetailDto);
        }
    }

    public void modifyPost(PostRequestDto postRequestDto) {
        //TODO 로그인 구현 후 세션에서 유저 정보 데이터 추가
        postMapper.updatePost(postRequestDto.getPostDto());
        for(PostDetailDto postDetailDto : postRequestDto.getPostDetailDtoList()) {
            Long postId = postRequestDto.getPostDto().getPostId();
            postDetailDto.setPostId(postId);
            postMapper.updatePostDetail(postDetailDto);
        }
    }

    public void removePost(Long id) {
        postMapper.deletePostDetail(id);
        postMapper.deletePost(id);
    }
}
