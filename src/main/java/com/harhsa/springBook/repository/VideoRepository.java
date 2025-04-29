package com.harhsa.springBook.repository;

import com.harhsa.springBook.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {
  Optional<List<Video>> findByName(String name);

  Optional<List<Video>> findByNameContainsOrDescriptionContainsAllIgnoreCase(
      String name, String description);
}
