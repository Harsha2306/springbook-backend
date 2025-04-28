package com.harhsa.springBook.service;

import com.harhsa.springBook.dto.VideoRequestDto;
import com.harhsa.springBook.dto.VideoResponseDto;
import com.harhsa.springBook.entity.Video;
import com.harhsa.springBook.repository.VideoRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class VideoService {
  private final VideoRepository videoRepository;

  public void create(VideoRequestDto newVideoRequestDto) {
    videoRepository.save(
        Video.builder()
            .name(newVideoRequestDto.name())
            .description(newVideoRequestDto.description())
            .build());
  }

  public List<VideoResponseDto> getVideoDtos() {
    return videoRepository.findAll().stream()
        .map(
            video ->
                VideoResponseDto.builder()
                    .id(video.getId())
                    .name(video.getName())
                    .description(video.getDescription())
                    .build())
        .toList();
  }
}
