package kr.co.scrumble.mapper;

import kr.co.scrumble.dto.model.PostDetailDto;
import kr.co.scrumble.dto.model.PostDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
