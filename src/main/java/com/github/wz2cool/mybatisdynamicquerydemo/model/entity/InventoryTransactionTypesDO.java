package com.github.wz2cool.mybatisdynamicquerydemo.model.entity;

import javax.persistence.*;

@Table(name = "inventory_transaction_types")
public class InventoryTransactionTypesDO {
    @Id
    @Column
    private Integer id;
    @Column
    private String typeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}