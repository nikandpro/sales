package com.sales;

import com.sales.config.Config;
import com.sales.dao.SalesProductJdbcRepository;
import com.sales.model.Sales;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Config config = ctx.getBean("config",Config.class);
        SalesProductJdbcRepository salesProductJdbcRepository = new SalesProductJdbcRepository(config.jdbcTemplate());
        List<Sales> sales = salesProductJdbcRepository.index();
        for (Sales sale: sales) {
            System.out.println(sale.toString());
        }
    }
}
