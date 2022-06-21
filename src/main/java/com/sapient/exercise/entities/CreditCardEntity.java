package com.sapient.exercise.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "credit_card_details")
public class CreditCardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "card_name", nullable = false)
    private String cardName;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "balance_amount", nullable = false, columnDefinition = "float default 0")
    private float balanceAmount;

    @Column(name = "limit_amount", nullable = false)
    private float limitAmount;
}
