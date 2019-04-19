package com.ashish.microsevices.currencyexchangeservice;

import com.ashish.microsevices.currencyexchangeservice.controller.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Integer> {
    ExchangeValue findByFromAndTo(String from ,String to);
}
