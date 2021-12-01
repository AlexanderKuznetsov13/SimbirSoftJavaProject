package ru.alex.kuznetsov.project.simbirsoft.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.alex.kuznetsov.project.simbirsoft.feign.dto.AccountResponseDto;
import ru.alex.kuznetsov.project.simbirsoft.feign.dto.OperationRequestDto;

@FeignClient(name = "bank", url = "${account.api-url}")
public interface IAccountClient {

    @GetMapping(value = "/account/{number}/balance")
    AccountResponseDto getBalance(@PathVariable Integer number);

    @PutMapping(value = "/account/{number}/operation")
    AccountResponseDto makeOperation(@PathVariable Integer number, @RequestBody OperationRequestDto requestDto);
}
