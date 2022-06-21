package com.sapient.exercise.services;

import com.sapient.exercise.exceptions.CreditCardException;
import com.sapient.exercise.models.CreditCardRequestDto;
import com.sapient.exercise.models.CreditCardResponseDto;

import java.util.List;

public interface CreditCardService {

    void saveCreditCardDetails(CreditCardRequestDto requestDto) throws CreditCardException;

    List<CreditCardResponseDto> getAllCreditCardDetails();
}
