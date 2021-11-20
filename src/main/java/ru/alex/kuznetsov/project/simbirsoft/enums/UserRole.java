package ru.alex.kuznetsov.project.simbirsoft.enums;

public enum UserRole {
    ADMIN("ADMIN"),
    LEADER("LEADER"),
    CUSTOMER("CUSTOMER"),
    CONTRACTOR("CONTRACTOR");

    private final String name;

    UserRole(String name) {
        this.name = name;
    }

}

