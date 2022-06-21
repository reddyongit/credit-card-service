package com.sapient.exercise.controllers;

import com.sapient.exercise.models.CreditCardRequestDto;
import com.sapient.exercise.services.CreditCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.security.auth.login.CredentialException;

import static com.sapient.exercise.test.helper.CreditCardTestData.aCreditCardRequestDto;
import static com.sapient.exercise.test.helper.CreditCardTestData.aInvalidCreditCardRequestDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreditCardControllerTest {

    private CreditCardController unit;

    @Mock
    private CreditCardService creditCardServiceMock;

    @BeforeEach
    public void setup(){
        unit = new CreditCardController(creditCardServiceMock);
    }

    @Test
    void test_saveCardDetailsAsExpected(){

        //given
        CreditCardRequestDto requestDto = aCreditCardRequestDto();

        //when
        ResponseEntity<Void> responseEntity = unit.addCreditCardDetails(requestDto);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        verify(creditCardServiceMock, times(1)).saveCreditCardDetails(requestDto);

    }

    @Test
    void test_saveInvalidCardDetails_ReturnsBadRequest(){

        //given
        CreditCardRequestDto requestDto = aInvalidCreditCardRequestDto();

        //when
        ResponseEntity<Void> responseEntity = unit.addCreditCardDetails(requestDto);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

    }

}
