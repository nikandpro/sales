package com.sales;

import com.sales.config.Config;
import com.sales.dao.SalesProductJdbcRepository;
import com.sales.model.Sales;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Config config = ctx.getBean("config",Config.class);
        SalesProductJdbcRepository salesProductJdbcRepository = new SalesProductJdbcRepository(config.jdbcTemplate());
        List<Sales> sales = new ArrayList<>();
        Sales sales1 = new Sales(2, 23, Date.valueOf("2023-04-14"),Date.valueOf("2023-04-15"));
        salesProductJdbcRepository.save(sales1);
        sales = salesProductJdbcRepository.index();
        for (Sales sale: sales) {
            System.out.println(sale.toString());
        }
    }
}
