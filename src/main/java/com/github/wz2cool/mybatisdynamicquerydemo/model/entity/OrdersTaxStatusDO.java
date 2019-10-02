package com.github.wz2cool.mybatisdynamicquerydemo.model.entity;

import javax.persistence.*;

@Table(name = "orders_tax_status")
public class OrdersTaxStatusDO {
    @Id
    @Column
    private Integer id;
    @Column
    private String taxStatusName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaxStatusName() {
        return taxStatusName;
    }

    public void setTaxStatusName(String taxStatusName) {
        this.taxStatusName = taxStatusName;
    }

}