package kr.co.scrumble.post.dto.request;

import kr.co.scrumble.post.dto.model.PostDetailDto;
import kr.co.scrumble.post.dto.model.PostDto;
import lombok.Data;

import java.util.List;

@Data
public class PostRequestDto {

    private PostDto postDto;

    private List<PostDetailDto> postDetailDtoList;

    private String userNo;

    private Long page;
}
