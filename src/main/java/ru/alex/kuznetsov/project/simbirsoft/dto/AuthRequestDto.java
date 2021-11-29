package ru.alex.kuznetsov.project.simbirsoft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Auth request")
public class AuthRequestDto {

    @Schema(description = "Логин")
    private String login;

    @Schema(description = "Пароль")
    private String password;

    public AuthRequestDto(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
