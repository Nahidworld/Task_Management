package com.nahid.tasks.service;

import com.nahid.tasks.entity.TaskList;

import java.util.List;

public interface TaskListService {
    
    List<TaskList> listTaskLists();
    TaskList createTaskList(TaskList taskList);
}
