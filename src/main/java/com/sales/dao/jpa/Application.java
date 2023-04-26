package com.sales.dao.jpa;

import com.sales.model.Sales;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class Application {

    private final SalesJPARepository salesJPARepository;

    public Application(SalesJPARepository salesJPARepository) {
        this.salesJPARepository = salesJPARepository;
    }

    public Iterable<Sales> getSales() {
        return salesJPARepository.findAll();
    }



}
