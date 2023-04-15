package com.example.todo.models;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    private LocalDate createdDate;
    private String task;
    private boolean completed;

    public Task(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
        this.description = description;
        this.createdDate = createdDate;
    }
    public Long getId() {

        return id;
    }
    public void setId(Long id) {

        this.id = id;
    }
    public String getTask() {

        return task;
    }
    public void setTask(String task) {

        this.task = task;
    }
    public boolean isCompleted() {

        return completed;
    }
    public void setCompleted(boolean completed) {

        this.completed = completed;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}