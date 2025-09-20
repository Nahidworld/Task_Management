package com.nahid.tasks.repository;

import com.nahid.tasks.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTaskListId(Long taskListId);
    Optional<Task> findByTaskListIdAndId(Long taskListId, Long id);
}
