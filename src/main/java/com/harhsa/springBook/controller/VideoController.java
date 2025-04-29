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

  @GetMapping("byName")
  public List<VideoResponseDto> getVideosByName(@RequestParam String name) {
    return videoService.getVideosByName(name);
  }

  @GetMapping("search")
  public List<VideoResponseDto> getVideosByNameAndDescription(
      @RequestBody VideoRequestDto videoRequestDto) {
    return videoService.getVideosByNameAndDescription(
        videoRequestDto.name(), videoRequestDto.description());
  }

  @PostMapping
  public void postVideo(@RequestBody VideoRequestDto newVideoRequestDto) {
    videoService.create(newVideoRequestDto);
  }
}
