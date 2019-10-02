package com.github.wz2cool.mybatisdynamicquerydemo.model.entity;

import javax.persistence.*;

@Table(name = "orders_status")
public class OrdersStatusDO {
    @Id
    @Column
    private Integer id;
    @Column
    private String statusName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

}