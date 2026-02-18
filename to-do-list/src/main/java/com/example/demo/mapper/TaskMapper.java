package com.example.demo.mapper;

import com.example.demo.dto.request.RequestCreateTaskDto;
import com.example.demo.dto.response.ResponsePaginationTaskDto;
import com.example.demo.dto.response.ResponseTaskDto;
import com.example.demo.model.TaskModel;
import org.springframework.data.domain.Page;
import java.util.List;

public class TaskMapper {

    public TaskModel toModel(Long userId, RequestCreateTaskDto dto) {
        return new TaskModel(userId, dto.title(),  dto.description());
    }

    public ResponseTaskDto toDto(TaskModel task) {
        return new ResponseTaskDto(task.getTitle(), task.getDescription());
    }

    public ResponsePaginationTaskDto toPaginationDto(Page<TaskModel> tasks) {
        List<ResponseTaskDto> content = tasks.stream().map(
                t -> new ResponseTaskDto(
                        t.getTitle(),
                        t.getDescription()
                )
        ).toList();
        return new ResponsePaginationTaskDto(content, tasks.getTotalPages(), tasks.getTotalElements(), tasks.getSize(), tasks.getNumber());
    }
}
