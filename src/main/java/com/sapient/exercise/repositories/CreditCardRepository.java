package com.sapient.exercise.repositories;


import com.sapient.exercise.entities.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Integer> {

}
