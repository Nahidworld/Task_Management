package com.nahid.tasks.dto;

import com.nahid.tasks.entity.TaskList;
import com.nahid.tasks.enums.TaskPriority;
import com.nahid.tasks.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDateTime dueDate,
        TaskStatus status,
        TaskPriority priority

) {



}
