package com.nahid.tasks.mapper;

import com.nahid.tasks.dto.TaskListDto;
import com.nahid.tasks.entity.TaskList;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
