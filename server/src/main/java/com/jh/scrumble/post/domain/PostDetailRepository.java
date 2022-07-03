package com.jh.scrumble.post.domain;

import com.jh.scrumble.post.dto.entity.PostDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostDetailRepository extends JpaRepository<PostDetail, Long> {
}
