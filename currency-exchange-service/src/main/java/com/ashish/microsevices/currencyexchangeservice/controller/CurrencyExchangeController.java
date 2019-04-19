package com.ashish.microsevices.currencyexchangeservice.controller;

import com.ashish.microsevices.currencyexchangeservice.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

    @Autowired
    ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = null;
        Optional<ExchangeValue> exchangeValueOptional = Optional.of(repository.findByFromAndTo(from,to));
        if(exchangeValueOptional.isPresent())
        {
            exchangeValue =  exchangeValueOptional.get();
            exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        }
        return exchangeValue;
    }
}
