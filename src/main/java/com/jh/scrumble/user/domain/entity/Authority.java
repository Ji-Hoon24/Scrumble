package com.jh.scrumble.user.domain.entity;

import com.jh.scrumble.common.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority extends BaseTimeEntity {

   @Id
   @Column(name = "authority_name", length = 50)
   private String authorityName;
}
