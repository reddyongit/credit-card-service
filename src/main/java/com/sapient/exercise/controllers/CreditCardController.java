package com.sapient.exercise.controllers;

import com.sapient.exercise.models.CreditCardRequestDto;
import com.sapient.exercise.models.CreditCardResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/credit-cards")
@Tag(name = "Credit Card Details")
public class CreditCardController {


    @PostMapping
    @Operation(summary = "Saves Credit Card Details", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Data Added successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Void> addCreditCardDetails(@RequestBody @Valid CreditCardRequestDto requestDto)  {


        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping
    @Operation(summary = "Retrieves Credit Card Details", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Credit Card Details retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public List<CreditCardResponseDto> getCreditCardDetails() {

        return null;
    }
}
