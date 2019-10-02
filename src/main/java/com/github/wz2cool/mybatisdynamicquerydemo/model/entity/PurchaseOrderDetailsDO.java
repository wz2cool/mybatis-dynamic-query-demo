package com.github.wz2cool.mybatisdynamicquerydemo.model.entity;

import java.math.*;
import java.sql.Timestamp;
import javax.persistence.*;

@Table(name = "purchase_order_details")
public class PurchaseOrderDetailsDO {
    @Column
    private Timestamp dateReceived;
    @Id
    @Column
    private Integer id;
    @Column
    private Integer inventoryId;
    @Column
    private Integer postedToInventory;
    @Column
    private Integer productId;
    @Column
    private Integer purchaseOrderId;
    @Column
    private BigDecimal quantity;
    @Column
    private BigDecimal unitCost;

    public Timestamp getDateReceived() {
        return dateReceived == null ? null : new Timestamp(dateReceived.getTime());
    }

    public void setDateReceived(Timestamp dateReceived) {
        this.dateReceived = dateReceived == null ? null : new Timestamp(dateReceived.getTime());
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

    public Integer getPostedToInventory() {
        return postedToInventory;
    }

    public void setPostedToInventory(Integer postedToInventory) {
        this.postedToInventory = postedToInventory;
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

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

}