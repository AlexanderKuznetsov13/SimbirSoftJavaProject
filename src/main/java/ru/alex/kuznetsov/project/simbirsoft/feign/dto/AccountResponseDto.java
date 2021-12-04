package ru.alex.kuznetsov.project.simbirsoft.feign.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "Информация об аккаунте")
public class AccountResponseDto {

    @Schema(description = "Идентификатор")
    private Integer id;

    @Schema(description = "Баланс")
    private Long balance;

    public AccountResponseDto() {
    }

    public AccountResponseDto(Integer id, Long balance) {
        this.id = id;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
