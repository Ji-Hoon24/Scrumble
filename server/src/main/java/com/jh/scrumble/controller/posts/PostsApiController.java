package com.jh.scrumble.controller.posts;

import com.jh.scrumble.domain.posts.dto.PostsSaveRequestDto;
import com.jh.scrumble.domain.posts.dto.PostsUpdateRequestDto;
import com.jh.scrumble.dto.PostsResponseDto;
import com.jh.scrumble.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }
}
