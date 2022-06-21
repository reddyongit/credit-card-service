package com.sapient.exercise.controllers;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.sapient.exercise.exceptions.CreditCardException;
import com.sapient.exercise.models.CreditCardRequestDto;
import com.sapient.exercise.models.CreditCardResponseDto;
import com.sapient.exercise.services.CreditCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.sapient.exercise.helper.CreditCardHelper.validateCardNumber;

/**
 * This class is to handle request for credit card operations such as persisting in DB
 * and retrieving all credit card details from table.
 */

@AllArgsConstructor
@RestController
@RequestMapping("/credit-cards")
@Tag(name = "Credit Card Details")
@Slf4j
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @PostMapping
    @Operation(summary = "Saves Credit Card Details", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Credit Card Details Created Successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "409", description = "Duplicate Card Details Requested"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Void> addCreditCardDetails(@RequestBody @Valid CreditCardRequestDto requestDto) {

        log.debug("Request received in controller for cardNumber {}", requestDto.getCardNumber());
        try {
            // validate card number using luhn algorithm
            if (validateCardNumber(requestDto.getCardNumber())) {
                log.debug("card number is valid and trying to persist");
                creditCardService.saveCreditCardDetails(requestDto);
                return new ResponseEntity<>(HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (CreditCardException ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    @Operation(summary = "Retrieves Credit Card Details", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Credit Card Details Retrieved Successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public List<CreditCardResponseDto> getCreditCardDetails() {

        log.debug("Request received in controller for all card details");
        //Get all credit card details from table
        return creditCardService.getAllCreditCardDetails();
    }


}
