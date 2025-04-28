package com.harhsa.springBook.repository;

import com.harhsa.springBook.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
