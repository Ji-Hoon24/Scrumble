package com.jh.scrumble.post.controller;

import com.jh.scrumble.config.ApiResultUtil.ApiResult;
import com.jh.scrumble.post.dto.request.PostsSaveRequestDto;
import com.jh.scrumble.post.dto.request.PostsUpdateRequestDto;
import com.jh.scrumble.post.dto.response.PostsResponseDto;
import com.jh.scrumble.post.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jh.scrumble.config.ApiResultUtil.success;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/")
    public ApiResult<Long> save(@RequestBody PostsSaveRequestDto requestDto) {
        return success(postsService.save(requestDto));
    }

    @GetMapping("/{id}")
    public ApiResult<PostsResponseDto> findById(@PathVariable Long id) {
        return success(postsService.findById(id));
    }

    @PutMapping("/{id}")
    public ApiResult<Long> update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return success(postsService.update(id, requestDto));
    }

    @DeleteMapping("/{id}")
    public ApiResult<Long> delete(@PathVariable Long id) {
        postsService.delete(id);
        return success(id);
    }

    @GetMapping("/list/{page}")
    public ApiResult<List<PostsResponseDto>> postsList(@PathVariable Long page) {
        List<PostsResponseDto> list = postsService.postsList(page);
        return success(list);
    }

}
