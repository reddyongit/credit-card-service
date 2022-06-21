package com.sapient.exercise.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditCardRequestDto implements Serializable {

    @NotEmpty(message = "Card Name shouldn't be empty")
    @Schema(required = true)
    private String cardName;

    @NotEmpty(message = "Card Number shouldn't be empty")
    @Schema(required = true)
    private String cardNumber;

    @Min(value = 1, message = "Limit Amount shouldn't be minimum 1")
    @Schema(required = true)
    private float limitAmount;
}
