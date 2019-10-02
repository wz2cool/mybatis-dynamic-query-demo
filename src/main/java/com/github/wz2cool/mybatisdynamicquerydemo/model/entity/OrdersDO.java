package com.github.wz2cool.mybatisdynamicquerydemo.model.entity;

import java.math.*;
import java.sql.*;
import javax.persistence.*;

@Table(name = "orders")
public class OrdersDO {
    @Column
    private Integer customerId;
    @Column
    private Integer employeeId;
    @Id
    @Column
    private Integer id;
    @Column
    private String notes;
    @Column
    private Timestamp orderDate;
    @Column
    private Timestamp paidDate;
    @Column
    private String paymentType;
    @Column
    private String shipAddress;
    @Column
    private String shipCity;
    @Column
    private String shipCountryRegion;
    @Column
    private String shipName;
    @Column
    private String shipStateProvince;
    @Column
    private String shipZipPostalCode;
    @Column
    private Timestamp shippedDate;
    @Column
    private Integer shipperId;
    @Column
    private BigDecimal shippingFee;
    @Column
    private Integer statusId;
    @Column
    private Double taxRate;
    @Column
    private Integer taxStatusId;
    @Column
    private BigDecimal taxes;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Timestamp getOrderDate() {
        return orderDate == null ? null : new Timestamp(orderDate.getTime());
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate == null ? null : new Timestamp(orderDate.getTime());
    }

    public Timestamp getPaidDate() {
        return paidDate == null ? null : new Timestamp(paidDate.getTime());
    }

    public void setPaidDate(Timestamp paidDate) {
        this.paidDate = paidDate == null ? null : new Timestamp(paidDate.getTime());
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipCountryRegion() {
        return shipCountryRegion;
    }

    public void setShipCountryRegion(String shipCountryRegion) {
        this.shipCountryRegion = shipCountryRegion;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipStateProvince() {
        return shipStateProvince;
    }

    public void setShipStateProvince(String shipStateProvince) {
        this.shipStateProvince = shipStateProvince;
    }

    public String getShipZipPostalCode() {
        return shipZipPostalCode;
    }

    public void setShipZipPostalCode(String shipZipPostalCode) {
        this.shipZipPostalCode = shipZipPostalCode;
    }

    public Timestamp getShippedDate() {
        return shippedDate == null ? null : new Timestamp(shippedDate.getTime());
    }

    public void setShippedDate(Timestamp shippedDate) {
        this.shippedDate = shippedDate == null ? null : new Timestamp(shippedDate.getTime());
    }

    public Integer getShipperId() {
        return shipperId;
    }

    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getTaxStatusId() {
        return taxStatusId;
    }

    public void setTaxStatusId(Integer taxStatusId) {
        this.taxStatusId = taxStatusId;
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

    public void setTaxes(BigDecimal taxes) {
        this.taxes = taxes;
    }

}