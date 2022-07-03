package com.jh.scrumble.common.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @Schema(hidden = true)
    @CreatedDate
    private LocalDateTime createdDate;

    @Schema(hidden = true)
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
