package com.sales.dao;

import com.sales.model.Sales;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesMapper implements RowMapper<Sales> {
    @Override
    public Sales mapRow(ResultSet rs, int rowNum) throws SQLException {
        Sales sales = new Sales();

        sales.setId_Sale(rs.getInt("id_Sale"));
        sales.setSumSales(rs.getInt("sumSales"));
        sales.setDateSupply(rs.getDate("dateSupply"));
        sales.setDateOfSale(rs.getDate("dateOfSale"));

        return sales;
    }
}
