package kr.co.scrumble.post.service;

import kr.co.scrumble.post.dto.model.PostDetailDto;
import kr.co.scrumble.post.dto.model.PostDto;
import kr.co.scrumble.post.dto.request.PostRequestDto;
import kr.co.scrumble.post.dto.result.PostResultDto;
import kr.co.scrumble.post.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostSelectService {

    @Autowired
    PostMapper postMapper;

    public PostDto selectPost(Long id) {
        return postMapper.selectPost(id);
    }

    public List<PostResultDto> selectPostResultList(PostRequestDto postRequestDto) {
        List<PostResultDto> resultDtoList = new ArrayList<>();
        List<PostDto> postDtoList = postMapper.selectPostPage(postRequestDto);
        for(PostDto postDto : postDtoList) {
            PostResultDto resultDto = new PostResultDto();
            List<PostDetailDto> postDetailDtoList = postMapper.selectPostDetailList(postDto);
            resultDto.setPostDto(postDto);
            resultDto.setPostDetailDtoList(postDetailDtoList);
            resultDtoList.add(resultDto);
        }
        return resultDtoList;
    }
}
