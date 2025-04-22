package com.harhsa.springBook.controller;

import com.harhsa.springBook.dto.Video;
import com.harhsa.springBook.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:5173")
public class VideoController {
  private final VideoService videoService;

  @GetMapping
  public List<Video> getVideos() {
    return videoService.getVideos();
  }

  @PostMapping
  public void postVideo(@RequestBody Video newVideo){
    videoService.create(newVideo);
  }
}
