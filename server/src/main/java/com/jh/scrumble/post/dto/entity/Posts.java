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
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @Column(length = 500, nullable = false)
    @Schema(description = "해당 게시글의 제목" , example = "테스트 데이터 입력")
    private String title;

    @Schema(hidden = true)
    private String author;

    @Schema(description = "해당 게시글 일자" , example = "2022-05-15")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date postDt;

    @Builder
    public Posts(String title, String author, Date postDt) {
        this.title = title;
        this.author = author;
        this.postDt = postDt;
    }

    public void update(String title, Date postDt) {
        this.title = title;
        this.postDt = postDt;
    }
}
