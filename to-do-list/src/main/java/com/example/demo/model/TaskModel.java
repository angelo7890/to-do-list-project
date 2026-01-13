package com.example.demo.model;

import com.example.demo.enums.StatusTaskEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long userId;
    @Column(nullable = false)
    private String title;
    @Lob
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTaskEnum status;

    public TaskModel() {

    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if(this.status == null){
            this.status = StatusTaskEnum.IN_PROGRESS;
        }
    }

    public TaskModel(Long userId, String title, String description) {
        this.userId = userId;
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public StatusTaskEnum getStatus() {
        return status;
    }

    public void setStatus(StatusTaskEnum status) {
        this.status = status;
    }
}
