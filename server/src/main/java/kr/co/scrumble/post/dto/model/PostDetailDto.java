package kr.co.scrumble.post.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("postDetailDto")
public class PostDetailDto {

    @Schema(hidden = true)
    private Long detailId;

    @Schema(hidden = true)
    private Long postId;

    @Schema(description = "해당 게시글의 내용" , example = "테스트 내용1")
    private String contents;

    @Schema(description = "해당 내용 완료 여부" , example = "N")
    private String completeYn;

    @Schema(description = "해당 게시글 구분 여부(TODO : 해야할 것 / DONE : 완료)" , example = "TODO")
    private String postCd;

    @Schema(hidden = true)
    private String regId;

    @Schema(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regDt;

    @Schema(hidden = true)
    private String udtId;

    @Schema(hidden = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date udtDt;
}
