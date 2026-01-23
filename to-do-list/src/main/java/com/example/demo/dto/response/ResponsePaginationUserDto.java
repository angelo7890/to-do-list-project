package com.example.demo.dto.response;

import java.util.List;

public record ResponsePaginationUserDto(
        List<ResponseUserDto> content,
        int totalPages,
        long totalElements,
        int pageSize,
        int currentPages
) {
}
