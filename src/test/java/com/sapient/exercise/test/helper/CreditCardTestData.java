package com.sapient.exercise.test.helper;

import com.sapient.exercise.models.CreditCardRequestDto;

public class CreditCardTestData {

    public static CreditCardRequestDto aCreditCardRequestDto() {

        return CreditCardRequestDto.builder()
                .cardName("Reddeppa")
                .cardNumber("79927398713")
                .limitAmount(1200)
                .build();
    }
}
