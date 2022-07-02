package kr.co.scrumble.dto.result;

import kr.co.scrumble.dto.model.PostDetailDto;
import kr.co.scrumble.dto.model.PostDto;
import lombok.Data;

import java.util.List;

@Data
public class PostResultDto {

    private PostDto postDto;

    private List<PostDetailDto> postDetailDtoList;
}
