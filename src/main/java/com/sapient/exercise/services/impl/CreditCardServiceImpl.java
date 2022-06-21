package com.sapient.exercise.services.impl;

import com.sapient.exercise.models.CreditCardRequestDto;
import com.sapient.exercise.models.CreditCardResponseDto;
import com.sapient.exercise.repositories.CreditCardRepository;
import com.sapient.exercise.services.CreditCardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;



    @Override
    public void saveCreditCardDetails(CreditCardRequestDto requestDto) {

    }

    @Override
    public List<CreditCardResponseDto> getAllCreditCardDetails() {
        return null;
    }
}
