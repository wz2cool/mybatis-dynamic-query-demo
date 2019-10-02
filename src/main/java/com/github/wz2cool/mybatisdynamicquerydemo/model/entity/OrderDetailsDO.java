package com.github.wz2cool.mybatisdynamicquerydemo.model.entity;

import java.math.*;
import java.sql.Timestamp;
import javax.persistence.*;

@Table(name = "order_details")
public class OrderDetailsDO {
    @Column
    private Timestamp dateAllocated;
    @Column
    private Double discount;
    @Id
    @Column
    private Integer id;
    @Column
    private Integer inventoryId;
    @Column
    private Integer orderId;
    @Column
    private Integer productId;
    @Column
    private Integer purchaseOrderId;
    @Column
    private BigDecimal quantity;
    @Column
    private Integer statusId;
    @Column
    private BigDecimal unitPrice;

    public Timestamp getDateAllocated() {
        return dateAllocated == null ? null : new Timestamp(dateAllocated.getTime());
    }

    public void setDateAllocated(Timestamp dateAllocated) {
        this.dateAllocated = dateAllocated == null ? null : new Timestamp(dateAllocated.getTime());
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

}