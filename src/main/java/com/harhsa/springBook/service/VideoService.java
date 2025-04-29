package com.harhsa.springBook.service;

import com.harhsa.springBook.dto.VideoRequestDto;
import com.harhsa.springBook.dto.VideoResponseDto;
import com.harhsa.springBook.entity.Video;
import com.harhsa.springBook.repository.VideoRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class VideoService {
  private final VideoRepository videoRepository;

  public void create(VideoRequestDto newVideoRequestDto) {
    videoRepository.save(mapToVideo(newVideoRequestDto));
  }

  public List<VideoResponseDto> getVideoDtos() {
    return videoRepository.findAll().stream().map(this::mapToVideoResponseDto).toList();
  }

  public List<VideoResponseDto> getVideosByName(String name) {
    Optional<List<Video>> optionalVideos = videoRepository.findByName(name);
    return optionalVideos
        .map(videos -> videos.stream().map(this::mapToVideoResponseDto).toList())
        .orElseGet(ArrayList::new);
  }

  private VideoResponseDto mapToVideoResponseDto(Video video) {
    return VideoResponseDto.builder()
        .id(video.getId())
        .name(video.getName())
        .description(video.getDescription())
        .build();
  }

  private Video mapToVideo(VideoRequestDto videoRequestDto) {
    return Video.builder()
        .name(videoRequestDto.name())
        .description(videoRequestDto.description())
        .build();
  }

  public List<VideoResponseDto> getVideosByNameAndDescription(String name, String description) {
    Optional<List<Video>> optionalVideos =
        videoRepository.findByNameContainsOrDescriptionContainsAllIgnoreCase(name, description);
    return optionalVideos
        .map(videos -> videos.stream().map(this::mapToVideoResponseDto).toList())
        .orElseGet(ArrayList::new);
  }
}
