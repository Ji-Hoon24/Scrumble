package kr.co.scrumble.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {

    private Long id;

    private String author;

    private String title;

    private String userNo;

    private String regId;

    private Date regDt;

    private String udtId;

    private Date udtDt;
}
