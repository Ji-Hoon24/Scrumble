package com.jh.scrumble.post.controller;

import com.jh.scrumble.post.dto.request.PostsSaveRequestDto;
import com.jh.scrumble.post.dto.request.PostsUpdateRequestDto;
import com.jh.scrumble.post.dto.response.PostsResponseDto;
import com.jh.scrumble.post.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/list/{page}")
    public List<PostsResponseDto> postsList(@PathVariable Long page) {
        List<PostsResponseDto> list = postsService.postsList(page);
        return list;
    }

}
