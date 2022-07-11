package com.jh.scrumble.post.domain;

import com.jh.scrumble.post.dto.entity.Posts;
import com.jh.scrumble.post.dto.response.PostsListResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    @Query("SELECT p FROM Posts p WHERE p.id <= :page ORDER BY p.id DESC")
    List<Posts> findTop10ByPage(Long page);
}
