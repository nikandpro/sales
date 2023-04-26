package com.sales.dao;

import com.sales.config.Config;
import com.sales.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class SalesProductJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesProductJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    //new SalesMapper() == new BeanPropertyRowMapper<>(Sales.class) if table and class attributes are the same
    @GetMapping("/sales")
    public List<Sales> index() {
        return jdbcTemplate.query("SELECT * FROM sales",new BeanPropertyRowMapper<>(Sales.class))
                .stream().filter(sales1 -> sales1.getSumSales()>100).toList();

    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM sales", Integer.class);
    }

    public Sales show(int id) {
        return jdbcTemplate.query("SELECT * FROM sales WHERE id_Sale=?", new Object[]{id}, new SalesMapper()).stream().findAny().orElse(null);
    }

    public void save(Sales sales) {
        jdbcTemplate.update("INSERT INTO sales VALUES(?, ?, ?, ?)",sales.getId_Sale(), sales.getSumSales(), sales.getDateSupply(), sales.getDateOfSale());
    }




}
