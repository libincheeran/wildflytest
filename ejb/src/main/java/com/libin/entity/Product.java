package com.libin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @Column(name = "ID")
    private Double id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MULTIVENDOR")
    private String multivendor;

    @Column(name = "VENDOR_ELIGIBLE_SELECTION")
    private String vendorEligSelection;

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMultivendor() {
        return multivendor;
    }

    public void setMultivendor(String multivendor) {
        this.multivendor = multivendor;
    }

    public String getVendorEligSelection() {
        return vendorEligSelection;
    }

    public void setVendorEligSelection(String vendorEligSelection) {
        this.vendorEligSelection = vendorEligSelection;
    }
}
