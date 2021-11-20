package ru.alex.kuznetsov.project.simbirsoft.enums;

public enum TaskState {
    BACKLOG("BACKLOG"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE("DONE");

    private final String name;

    TaskState(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
