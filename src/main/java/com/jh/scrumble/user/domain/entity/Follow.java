package com.jh.scrumble.user.domain.entity;

import com.jh.scrumble.common.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Follow extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long followSeq;

    @Column
    private Long followId;

    @Column
    private Long followerId;

    @Builder
    public Follow(Long followId, Long followerId) {
        this.followId = followId;
        this.followerId = followerId;
    }
}
