package com.example.ministory.repository;

import com.example.ministory.entity.Post;
import com.example.ministory.entity.Scrap;
import com.example.ministory.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapRepository extends JpaRepository<Scrap, Long> {

	Optional<Scrap> findByUserAndPost(User user, Post post);
}
