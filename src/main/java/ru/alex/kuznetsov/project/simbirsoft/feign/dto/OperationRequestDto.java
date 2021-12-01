package ru.alex.kuznetsov.project.simbirsoft.feign.dto;

public class OperationRequestDto {
    private Long diffValue;

    public OperationRequestDto() {
    }

    public OperationRequestDto(Long diffValue) {
        this.diffValue = diffValue;
    }

    public Long getDiffValue() {
        return diffValue;
    }

    public void setDiffValue(Long diffValue) {
        this.diffValue = diffValue;
    }
}
