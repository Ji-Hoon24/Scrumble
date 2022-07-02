package kr.co.scrumble.dto.request;

import kr.co.scrumble.dto.model.PostDetailDto;
import kr.co.scrumble.dto.model.PostDto;
import lombok.Data;

import java.util.List;

@Data
public class PostRequestDto {

    private PostDto postDto;

    private List<PostDetailDto> postDetailDtoList;
}
