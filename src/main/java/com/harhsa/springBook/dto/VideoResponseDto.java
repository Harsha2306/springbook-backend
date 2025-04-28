package com.harhsa.springBook.dto;

import lombok.Builder;

@Builder
public record VideoResponseDto(Long id, String name, String description) {}
