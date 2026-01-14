package com.example.demo.repository;

import com.example.demo.model.TaskModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskModel,Long> {
    @Query("""
    SELECT t
    FROM TaskModel t
    WHERE t.userId = :userId
""")
    Page<TaskModel> findAllByUserId(
            @Param("userId") Long userId,
            Pageable pageable
    );
}
