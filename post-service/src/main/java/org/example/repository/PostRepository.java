package org.example.repository;

import org.example.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Aliaksei.Kurbatau
 * @since 3/11/2023
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByUserId(Long userId);

    void deleteAllByUserId(Long userId);
}
