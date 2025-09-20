package com.nahid.tasks.controller;

import com.nahid.tasks.dto.ErrorResponse;
import com.nahid.tasks.dto.ErrorResponseDto;
import com.nahid.tasks.dto.TaskListDto;
import com.nahid.tasks.entity.TaskList;
import com.nahid.tasks.mapper.TaskListMapper;
import com.nahid.tasks.service.TaskListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskLists()
                .stream()
                .map(taskListMapper::toDto)
                .toList();
    }

    @Operation(
            summary = "Create Task list Rest API",
            description = "For Create Task list"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Http Status 201 created"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status 500 Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }

    )
    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList =  taskListService.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(createdTaskList);
    }

    @GetMapping(path = "{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") Long taskListId) {
        return  taskListService.getTaskList(taskListId).map(taskListMapper::toDto);
    }
}
