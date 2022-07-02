package kr.co.scrumble.controller;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import kr.co.scrumble.dto.model.PostDetailDto;
import kr.co.scrumble.dto.model.PostDto;
import kr.co.scrumble.dto.request.PostRequestDto;
import kr.co.scrumble.dto.result.PostResultDto;
import kr.co.scrumble.service.post.PostCommandService;
import kr.co.scrumble.service.post.PostSelectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostSelectService postSelectService;

    @Autowired
    PostCommandService postCommandService;

    @ApiOperation(value="게시글 호출", notes="")
    @ApiResponses({
        @ApiResponse(code = 200, message = "API 정상 작동"),
        @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/{id}")
    @ResponseBody
    public PostDto selectPost(@Parameter(description = "게시글 ID값", required = true, example = "1") @PathVariable Long id) {
        PostDto result = postSelectService.selectPost(id);
        log.info(result.toString());
        return result;
    }

    @ApiOperation(value="게시글 입력", notes="")
    @ApiResponses({
        @ApiResponse(code = 200, message = "API 정상 작동"),
        @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/")
    public void savePost(@Parameter(description = "게시글 데이터 입력값", required = true) @RequestBody PostRequestDto postRequestDto) {
        //저장
        postCommandService.addPost(postRequestDto);
    }

    @ApiOperation(value="게시글 수정", notes="")
    @ApiResponses({
        @ApiResponse(code = 200, message = "API 정상 작동"),
        @ApiResponse(code = 500, message = "서버 에러")
    })
    @PutMapping("/")
    public void updatePost(@Parameter(description = "게시글 데이터 입력값", required = true) @RequestBody PostRequestDto postRequestDto) {
        postCommandService.modifyPost(postRequestDto);
    }

    @ApiOperation(value="게시글 삭제", notes="")
    @ApiResponses({
        @ApiResponse(code = 200, message = "API 정상 작동"),
        @ApiResponse(code = 500, message = "서버 에러")
    })
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postCommandService.removePost(id);
    }

    @ApiOperation(value="게시글 리스트 호출", notes="")
    @ApiResponses({
      @ApiResponse(code = 200, message = "API 정상 작동"),
      @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/list/{page}")
    @ResponseBody
    public List<PostResultDto> selectPostList(@Parameter(description = "페이징", required = true, example = "1") @PathVariable Long page) {
        PostRequestDto postRequestDto = new PostRequestDto();
        //TODO 로그인 구현 후 세션에서 유저 정보 데이터 추가
        postRequestDto.setPage(page);
        List<PostResultDto> result = postSelectService.selectPostResultList(postRequestDto);
        return result;
    }
}
