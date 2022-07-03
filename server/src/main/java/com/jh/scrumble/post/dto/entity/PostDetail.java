package com.jh.scrumble.post.dto.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jh.scrumble.common.domain.BaseTimeEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@Entity
public class PostDetail extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long detailId;

    @Schema(hidden = true)
    private Long id;

    @Column(length = 500, nullable = false)
    @Schema(description = "해당 게시글의 내용" , example = "테스트 내용1")
    private String contents;

    @Schema(description = "해당 내용 완료 여부" , example = "N")
    private String completeYn;

    @Schema(description = "해당 게시글 구분 여부(TODO : 해야할 것 / DONE : 완료)" , example = "TODO")
    private String postCd;

    @Builder
    public PostDetail(Long id, String contents, String completeYn, String postCd) {
        this.id = id;
        this.contents = contents;
        this.completeYn = completeYn;
        this.postCd = postCd;
    }

    public PostDetail setId(Long id) {
        this.id = id;
        return this;
    }
}
