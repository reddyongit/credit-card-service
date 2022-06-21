package com.sapient.exercise.test.helper;

import com.sapient.exercise.entities.CreditCardEntity;
import com.sapient.exercise.models.CreditCardRequestDto;
import com.sapient.exercise.models.CreditCardResponseDto;

import java.util.List;

public class CreditCardTestData {

    public static final String ERROR_MESSAGE = "Duplicate card details provided";

    public static CreditCardRequestDto aCreditCardRequestDto() {

        return CreditCardRequestDto.builder()
                .cardName("Reddeppa")
                .cardNumber("79927398713")
                .limitAmount(1200)
                .build();
    }

    public static CreditCardEntity aCreditCardEntity() {
        return CreditCardEntity.builder()
                .id(1)
                .cardName("Reddeppa")
                .cardNumber("79927398713")
                .limitAmount(1200)
                .build();
    }

    public static List<CreditCardEntity> aCreditCardEntityLisT() {
        return  List.of(aCreditCardEntity());
    }

    public static CreditCardResponseDto aCreditCardResponseDto() {

        return CreditCardResponseDto.builder()
                .id(1)
                .cardName("Reddeppa")
                .cardNumber("79927398713")
                .limitAmount("1200")
                .balanceAmount("0")
                .build();
    }

    public static List<CreditCardResponseDto> aCreditCardResponseDtoList() {

        return List.of(aCreditCardResponseDto());
    }
}
