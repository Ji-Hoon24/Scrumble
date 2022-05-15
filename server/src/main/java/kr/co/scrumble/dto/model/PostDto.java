package kr.co.scrumble.dto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Data
@Alias("postDto")
public class PostDto {

    @Schema(hidden = true)
    private Long postId;

    @Schema(description = "해당 게시글의 제목" , example = "테스트 데이터 입력")
    private String title;

    @Schema(hidden = true)
    private String userNo;

    @Schema(description = "해당 게시글 일자" , example = "2022-05-15")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date postDt;

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
