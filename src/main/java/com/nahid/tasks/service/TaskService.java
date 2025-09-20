package com.nahid.tasks.service;

import com.nahid.tasks.entity.Task;
import com.nahid.tasks.enums.TaskPriority;
import com.nahid.tasks.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

//    public TaskService(TaskRepository taskRepository) {      //constructor
//        this.taskRepository = taskRepository;
//    }

    public void createTask(){
        Task task = new Task();
        task.setTitle("Task 1");
        task.setDescription("Task Description");
        task.setDueDate(LocalDateTime.now());
        task.setPriority(TaskPriority.LOW);
        taskRepository.save(task);
    }

    public void updateTask(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        Task task = new Task();
        task.setTitle("Task 2");
        task.setDescription("Task Description");
        task.setDueDate(LocalDateTime.now());
        task.setPriority(TaskPriority.HIGH);
        taskRepository.save(task);
    }
}
