package ru.itis.akvelonitispractice.exceptions;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException() {
        super("Task not found");
    }
}
