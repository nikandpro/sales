package com.sales.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Sale;

    private int sumSales;

    private Date dateSupply;

    private Date dateOfSale;

    public Sales(int id_Sale, int sumSales, Date dateSupply, Date dateOfSale) {
        this.id_Sale = id_Sale;
        this.sumSales = sumSales;
        this.dateSupply = dateSupply;
        this.dateOfSale = dateOfSale;
    }

    public Sales() {}

    public int getId_Sale() {
        return id_Sale;
    }

    public void setId_Sale(int id_Sale) {
        this.id_Sale = id_Sale;
    }

    public int getSumSales() {
        return sumSales;
    }

    public void setSumSales(int sumSales) {
        this.sumSales = sumSales;
    }

    public Date getDateSupply() {
        return dateSupply;
    }

    public void setDateSupply(Date dateSupply) {
        this.dateSupply = dateSupply;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id_Sale=%d, sumSales='%s', dateSupply='%s', dateOfSale='%s']",
                id_Sale, sumSales, dateSupply, dateOfSale);
    }
}
