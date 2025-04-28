package com.harhsa.springBook.controller;

import com.harhsa.springBook.dto.VideoRequestDto;
import com.harhsa.springBook.dto.VideoResponseDto;
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
  public List<VideoResponseDto> getVideos() {
    return videoService.getVideoDtos();
  }

  @PostMapping
  public void postVideo(@RequestBody VideoRequestDto newVideoRequestDto) {
    videoService.create(newVideoRequestDto);
  }
}
