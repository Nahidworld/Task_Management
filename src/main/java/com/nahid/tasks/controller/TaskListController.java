package com.nahid.tasks.controller;

import com.nahid.tasks.dto.TaskListDto;
import com.nahid.tasks.entity.TaskList;
import com.nahid.tasks.mapper.TaskListMapper;
import com.nahid.tasks.service.TaskListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-List")
@RequiredArgsConstructor
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

//    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
//        this.taskListService = taskListService;
//        this.taskListMapper = taskListMapper;
//    }

    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList =  taskListService.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(createdTaskList);
    }

    @GetMapping(path = "{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID taskListId) {
        return  taskListService.getTaskList(taskListId).map(taskListMapper::toDto);
    }
}
