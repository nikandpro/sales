package com.sales.dao;

import com.sales.config.Config;
import com.sales.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
    public List<Sales> index() {
        return jdbcTemplate.query("SELECT * FROM sales",new BeanPropertyRowMapper<>(Sales.class));
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM sales", Integer.class);
    }

    public Sales show(int id) {
        return jdbcTemplate.query("SELECT * FROM sales WHERE id_Sale=?", new Object[]{id}, new SalesMapper()).stream().findAny().orElse(null);
    }




}
