package main.java.services;

import java.util.List;

import main.java.models.Task;
import main.java.enums.TaskStatus;

public class TaskService {
    public static Task createTask(String description, List<Task> tasks) {
        int id = generateId(tasks);

        return new Task(id, description, TaskStatus.TODO);
    }

    private static int generateId(List<Task> tasks) {
        int id = 1;

        if (!tasks.isEmpty()) {
            Task lastTask = tasks.get(tasks.size() - 1);

            id = lastTask.getId() + 1;
        }

        return id;
    }
}
