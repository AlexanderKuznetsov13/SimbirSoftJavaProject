package ru.alex.kuznetsov.project.simbirsoft.dto;


import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Пользователь")
public class UserRequestDto {

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

    public UserRequestDto() {
    }

    public UserRequestDto(int id, String name, String surname, String middlename, String nickname, String email, String password, int userTypeId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middlename = middlename;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
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





