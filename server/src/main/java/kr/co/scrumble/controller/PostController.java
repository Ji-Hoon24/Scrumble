package kr.co.scrumble.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import kr.co.scrumble.dto.PostDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @ApiOperation(value="게시글 호출", notes="")
    @ApiResponses({
        @ApiResponse(code = 200, message = "API 정상 작동"),
        @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/{id}")
    public void selectPost(@Parameter(description = "게시글 ID값", required = true, example = "1") @PathVariable Long id) {

    }

    @PostMapping("/")
    public void savePost(@RequestBody PostDto postDto) {
        //저장
    }

    @ApiOperation(value="게시글 수정", notes="")
    @ApiResponses({
        @ApiResponse(code = 200, message = "API 정상 작동"),
        @ApiResponse(code = 500, message = "서버 에러")
    })
    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id) {

    }

    @ApiOperation(value="게시글 삭제", notes="")
    @ApiResponses({
        @ApiResponse(code = 200, message = "API 정상 작동"),
        @ApiResponse(code = 500, message = "서버 에러")
    })
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {

    }
}
