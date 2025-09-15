package com.nahid.tasks.mapper;

import com.nahid.tasks.dto.TaskDto;
import com.nahid.tasks.entity.Task;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
