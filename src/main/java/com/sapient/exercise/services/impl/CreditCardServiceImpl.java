package com.sapient.exercise.services.impl;

import com.sapient.exercise.entities.CreditCardEntity;
import com.sapient.exercise.exceptions.CreditCardException;
import com.sapient.exercise.models.CreditCardRequestDto;
import com.sapient.exercise.models.CreditCardResponseDto;
import com.sapient.exercise.repositories.CreditCardRepository;
import com.sapient.exercise.services.CreditCardService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Service calls to handle Credit card persistence and retrieving from database
 */

@Slf4j
@AllArgsConstructor
@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private ModelMapper modelMapper;


    /**
     * Method that saves the credit card details into table
     *
     * @param requestDto
     */
    @Override
    @Transactional(readOnly = false)
    public void saveCreditCardDetails(CreditCardRequestDto requestDto) {

        // Check whether the duplicate credit card details are requested in request payload by checking it in db
        CreditCardEntity requestEntity = creditCardRepository.findByCardNumber(requestDto.getCardNumber());

        if (requestEntity == null) {
            //If not exists then save the details by using model mapper from dto to entity
            CreditCardEntity entity = modelMapper.map(requestDto, CreditCardEntity.class);
            CreditCardEntity retEntity = creditCardRepository.save(entity);
        } else {
            // If exist then don't return any response and log an error message
            log.error("Same Card details already present, so not adding as per Idempotency check");
            throw new CreditCardException("Duplicate card details provided");
        }

    }

    /**
     * Method to get the all credit card details from table
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<CreditCardResponseDto> getAllCreditCardDetails() {

        return creditCardRepository.findAll()
                .stream()
                .map((CreditCardEntity entity) -> modelMapper.map(entity, CreditCardResponseDto.class))
                .collect(Collectors.toList());
    }
}
