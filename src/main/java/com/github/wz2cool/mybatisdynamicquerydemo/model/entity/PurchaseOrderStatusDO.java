package com.github.wz2cool.mybatisdynamicquerydemo.model.entity;

import javax.persistence.*;

@Table(name = "purchase_order_status")
public class PurchaseOrderStatusDO {
    @Id
    @Column
    private Integer id;
    @Column
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}