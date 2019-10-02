package com.github.wz2cool.mybatisdynamicquerydemo.model.entity;

import java.sql.*;
import javax.persistence.*;

@Table(name = "inventory_transactions")
public class InventoryTransactionsDO {
    @Column
    private String comments;
    @Column
    private Integer customerOrderId;
    @Id
    @Column
    private Integer id;
    @Column
    private Integer productId;
    @Column
    private Integer purchaseOrderId;
    @Column
    private Integer quantity;
    @Column
    private Timestamp transactionCreatedDate;
    @Column
    private Timestamp transactionModifiedDate;
    @Column
    private Integer transactionType;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(Integer customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Timestamp getTransactionCreatedDate() {
        return transactionCreatedDate == null ? null : new Timestamp(transactionCreatedDate.getTime());
    }

    public void setTransactionCreatedDate(Timestamp transactionCreatedDate) {
        this.transactionCreatedDate = transactionCreatedDate == null ? null : new Timestamp(transactionCreatedDate.getTime());
    }

    public Timestamp getTransactionModifiedDate() {
        return transactionModifiedDate == null ? null : new Timestamp(transactionModifiedDate.getTime());
    }

    public void setTransactionModifiedDate(Timestamp transactionModifiedDate) {
        this.transactionModifiedDate = transactionModifiedDate == null ? null : new Timestamp(transactionModifiedDate.getTime());
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

}