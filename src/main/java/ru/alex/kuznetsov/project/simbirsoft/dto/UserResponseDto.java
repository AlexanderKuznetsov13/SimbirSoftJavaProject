package ru.alex.kuznetsov.project.simbirsoft.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Пользователь")
public class UserResponseDto {

    @Schema(description = "ID  пользователя")
    private int id;

    @Schema(description = "Имя пользователя")
    private String name;

    @Schema(description = "Фамилия пользователя")
    private String surname;

    @Schema(description = "Отчество пользователя")
    private String middlename;

    @Schema(description = "Логин пользователя")
    private String nickname;

    @Schema(description = "Почта пользователя")
    private String email;

    @Schema(description = "Пароль пользователя")
    private String password;

    @Schema(description = "Типа пользователя")
    private int userTypeId;

    public UserResponseDto() {
    }

    public UserResponseDto(int id, String name, String surname, String middlename, String nickname, String email, String password, int userTypeId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.userTypeId = userTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    @Override
    public String toString() {
        return "UserRequestDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userTypeId=" + userTypeId +
                '}';
    }
}





