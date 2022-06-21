package com.sapient.exercise.services.impl;

import com.sapient.exercise.entities.CreditCardEntity;
import com.sapient.exercise.exceptions.CreditCardException;
import com.sapient.exercise.models.CreditCardRequestDto;
import com.sapient.exercise.models.CreditCardResponseDto;
import com.sapient.exercise.repositories.CreditCardRepository;
import com.sapient.exercise.services.CreditCardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static com.sapient.exercise.test.helper.CreditCardTestData.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreditCardServiceImplTest {

    private CreditCardService unit;

    @Mock
    private CreditCardRepository creditCardRepositoryMock;

    @Mock
    private ModelMapper modelMapperMock;

    private CreditCardRequestDto requestDto;

    @BeforeEach
    public void setup(){
        this.unit = new CreditCardServiceImpl(creditCardRepositoryMock,modelMapperMock);
        requestDto = aCreditCardRequestDto();
    }

    @Test
    void test_saveCreditCardDetailsAsExpected(){

        CreditCardEntity entity = aCreditCardEntity();

        //given
        given(creditCardRepositoryMock.findByCardNumber("79927398713")).willReturn(null);
        given(modelMapperMock.map(requestDto, CreditCardEntity.class)).willReturn(aCreditCardEntity());
        given(creditCardRepositoryMock.save(entity)).willReturn(entity);

        //when
        unit.saveCreditCardDetails(requestDto);

        //Then
        verify(creditCardRepositoryMock, times(1)).save(entity);

    }

    @Test
    void test_saveCreditCardDetailsThrowException(){

        CreditCardEntity entity = aCreditCardEntity();

        //given
        given(creditCardRepositoryMock.findByCardNumber("79927398713")).willReturn(entity);


        //when
        Throwable throwable = catchThrowable(
                () -> unit.saveCreditCardDetails(requestDto));

        //Then
        assertThat(throwable).isInstanceOf(CreditCardException.class);
        assertThat(throwable.getMessage()).isEqualTo(ERROR_MESSAGE);

    }



    @Test
    void test_getCardDetailsAsExpected(){

        List<CreditCardResponseDto> expectedResp = aCreditCardResponseDtoList();
        given(creditCardRepositoryMock.findAll()).willReturn(aCreditCardEntityLisT());
        given(modelMapperMock.map(aCreditCardEntity(), CreditCardResponseDto.class)).willReturn(aCreditCardResponseDto());

        //when
        List<CreditCardResponseDto> actualResponse = unit.getAllCreditCardDetails();

        //Then
        assertThat(actualResponse).isEqualTo(expectedResp);

    }




}
