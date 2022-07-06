package com.jh.scrumble.post.domain;

import com.jh.scrumble.post.dto.entity.PostDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostDetailRepository extends JpaRepository<PostDetail, Long> {
    @Query("select pd from PostDetail pd where pd.id = :id")
    List<PostDetail> findAllById(@Param(value="id") Long id);
}
