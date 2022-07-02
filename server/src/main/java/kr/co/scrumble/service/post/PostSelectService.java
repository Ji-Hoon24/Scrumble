package kr.co.scrumble.service.post;

import kr.co.scrumble.dto.model.PostDto;
import kr.co.scrumble.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostSelectService {

    @Autowired
    PostMapper postMapper;

    public PostDto selectPost(Long id) {
        return postMapper.selectPost(id);
    }
}
