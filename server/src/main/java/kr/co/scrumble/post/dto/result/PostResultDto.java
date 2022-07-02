package kr.co.scrumble.post.dto.result;

import kr.co.scrumble.post.dto.model.PostDetailDto;
import kr.co.scrumble.post.dto.model.PostDto;
import lombok.Data;

import java.util.List;

@Data
public class PostResultDto {

    private PostDto postDto;

    private List<PostDetailDto> postDetailDtoList;
}
