package com.example.WaterTax2;

import jakarta.persistence.*;

@Entity
@Table(name = "property")
public class DataConfig2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "mobile_no")
    private Long mobileNo;

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }
    public Long getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(Long mobileNo) {
        this.mobileNo = mobileNo;
    }
}


