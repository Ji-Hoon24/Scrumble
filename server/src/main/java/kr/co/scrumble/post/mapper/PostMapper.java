package kr.co.scrumble.post.mapper;

import kr.co.scrumble.post.dto.model.PostDetailDto;
import kr.co.scrumble.post.dto.model.PostDto;
import kr.co.scrumble.post.dto.request.PostRequestDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostMapper {

    PostDto selectPost(Long id);

    Long insertPost(PostDto postDto);

    int updatePost(PostDto postDto);

    int deletePost(Long id);

    PostDetailDto selectPostDetail(Long detailId);

    int insertPostDetail(PostDetailDto postDetailDto);

    int updatePostDetail(PostDetailDto postDetailDto);

    int deletePostDetail(Long detailId);

    List<PostDto> selectPostPage(PostRequestDto postRequestDto);

    List<PostDetailDto> selectPostDetailList(PostDto postDto);
}
