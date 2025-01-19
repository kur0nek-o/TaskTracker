package main.java.models;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import main.java.enums.TaskStatus;

public class Task {
    private int id;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Task(int id, String description, TaskStatus status) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createdAt = getDateTime();
        this.updatedAt = getDateTime();
    }

    // Getters
    public int getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    // Setters
    public void setDescription(String description) {
        this.description = description;
        this.setUpdatedAt();
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
        this.setUpdatedAt();
    }

    private void setUpdatedAt() {
        this.updatedAt = getDateTime();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    private static LocalDateTime getDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());

        return zonedDateTime.toLocalDateTime();
    }
}
