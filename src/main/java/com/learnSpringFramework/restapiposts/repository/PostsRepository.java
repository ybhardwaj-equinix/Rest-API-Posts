package com.learnSpringFramework.restapiposts.repository;

import com.learnSpringFramework.restapiposts.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Integer> {
    
}
