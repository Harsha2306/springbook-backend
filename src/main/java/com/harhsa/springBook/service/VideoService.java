package com.harhsa.springBook.service;

import com.harhsa.springBook.dto.Video;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class VideoService {
  private List<Video> videos = new ArrayList<>();

  public void create(Video newVideo) {
    videos.add(newVideo);
  }
}