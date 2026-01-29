package com.example.demo.dto.request;

import com.example.demo.enums.StatusTaskEnum;

public record RequestUpdateTasksDto(
        String title,
        String description,
        StatusTaskEnum status
) {
}
