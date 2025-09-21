package com.nahid.tasks.service.impl;

import com.nahid.tasks.entity.TaskList;
import com.nahid.tasks.repository.TaskListRepository;
import com.nahid.tasks.service.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListServiceImpl implements TaskListService {

    private final TaskListRepository taskListRepository;

    public TaskListServiceImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public List<TaskList> listTaskLists() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTaskList(TaskList taskList) {
        if (null != taskList.getId()){
            throw new IllegalArgumentException("Task List already have an ID");
        }
        if(null == taskList.getTitle() || taskList.getTitle().isBlank()){
            throw new IllegalArgumentException("Task List title is required");
        }
        LocalDateTime now = LocalDateTime.now();
        return taskListRepository.save(new TaskList(
                null,
                taskList.getTitle(),
                taskList.getDescription(),
                null,
                now,
                now
        ));
    }

    @Override
    public Optional<TaskList> getTaskList(Long id) {
        return taskListRepository.findById(id);
    }

    @Override
    public TaskList updateTaskList(Long taskListId, TaskList taskList) {
        if(null == taskList.getId()){
            throw new IllegalArgumentException("Task List id is required");
        }
        if(Objects.equals(taskList.getId(), taskListId)){
            throw new IllegalArgumentException("Task List title is required");
        }
        TaskList existingTaskList = taskListRepository.findById(taskListId).orElseThrow(() ->
                new IllegalArgumentException("Task List id not found"));

        existingTaskList.setTitle(taskList.getTitle());
        existingTaskList.setDescription(taskList.getDescription());
        existingTaskList.setUpdated(LocalDateTime.now());
        return taskListRepository.save(existingTaskList);

    }

    @Override
    public void deleteTaskList(Long taskListId) {
        taskListRepository.deleteById(taskListId);
    }


}
