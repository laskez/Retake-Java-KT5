package com.example.retake_kt5.exception;

public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(Long id) {
        super("Задача с id=" + id + " не найдена");
    }
}