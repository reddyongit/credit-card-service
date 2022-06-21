package com.sapient.exercise.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardResponseDto {

    private Integer id;
    private String cardName;
    private String cardNumber;
    private String balanceAmount;
    private String limitAmount;
}
