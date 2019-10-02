package com.github.wz2cool.mybatisdynamicquerydemo.model.entity;

import java.math.BigDecimal;
import java.sql.*;
import javax.persistence.*;

@Table(name = "invoices")
public class InvoicesDO {
    @Column
    private BigDecimal amountDue;
    @Column
    private Timestamp dueDate;
    @Id
    @Column
    private Integer id;
    @Column
    private Timestamp invoiceDate;
    @Column
    private Integer orderId;
    @Column
    private BigDecimal shipping;
    @Column
    private BigDecimal tax;

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    public Timestamp getDueDate() {
        return dueDate == null ? null : new Timestamp(dueDate.getTime());
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate == null ? null : new Timestamp(dueDate.getTime());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getInvoiceDate() {
        return invoiceDate == null ? null : new Timestamp(invoiceDate.getTime());
    }

    public void setInvoiceDate(Timestamp invoiceDate) {
        this.invoiceDate = invoiceDate == null ? null : new Timestamp(invoiceDate.getTime());
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getShipping() {
        return shipping;
    }

    public void setShipping(BigDecimal shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

}