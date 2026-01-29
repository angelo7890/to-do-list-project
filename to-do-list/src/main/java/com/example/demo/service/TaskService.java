package com.example.demo.service;

import com.example.demo.dto.request.RequestCreateTaskDto;
import com.example.demo.dto.request.RequestUpdateTasksDto;
import com.example.demo.dto.response.ResponsePaginationTaskDto;
import com.example.demo.dto.response.ResponseTaskDto;
import com.example.demo.mapper.TaskMapper;
import com.example.demo.model.TaskModel;
import com.example.demo.repository.TaskRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper = new TaskMapper();

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void createTask(Long Userid, RequestCreateTaskDto dto){
        taskRepository.save(taskMapper.toModel(Userid, dto));
    }

    public ResponseTaskDto getTaskById(Long userId, Long taskId) {
        return taskRepository.findById(taskId)
                .map(taskMapper::toDto)
                .orElse(null);
    }

    public ResponsePaginationTaskDto findAllTasks(Long userId, int page , int size) {
        Pageable pageable = PageRequest.of(page, size);
        var tasks = taskRepository.findAllByUserId(userId, pageable);
        return taskMapper.toPaginationDto(tasks);
    }

    public void updateTaskById(Long taskId, RequestUpdateTasksDto dto){
        var task = taskRepository.findById(taskId).orElse(null);
        if (task != null){
            if(dto.title() != null){
                task.setTitle(dto.title());
            }
            if(dto.description() != null){
                task.setDescription(dto.description());
            }
            if(dto.status() != null){
                task.setStatus(dto.status());
            }
        }
    }

    public void deleteTaskById(Long taskId){
        taskRepository.deleteById(taskId);
    }
}
