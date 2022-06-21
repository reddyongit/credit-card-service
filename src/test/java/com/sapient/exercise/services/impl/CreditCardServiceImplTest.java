package com.sapient.exercise.services.impl;

import com.sapient.exercise.models.CreditCardRequestDto;
import com.sapient.exercise.repositories.CreditCardRepository;
import com.sapient.exercise.services.CreditCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.sapient.exercise.test.helper.CreditCardTestData.aCreditCardRequestDto;

@ExtendWith(MockitoExtension.class)
public class CreditCardServiceImplTest {

    private CreditCardService unit;

    @Mock
    private CreditCardRepository creditCardRepositoryMock;

    private CreditCardRequestDto requestDto;

    @BeforeEach
    public void setup(){
        this.unit = new CreditCardServiceImpl(creditCardRepositoryMock);
        requestDto = aCreditCardRequestDto();
    }

    @Test
    void test_saveCreditCardDetailsAsExpected(){

    }

    @Test
    void test_getCardDetailsAsExpected(){

    }


}
