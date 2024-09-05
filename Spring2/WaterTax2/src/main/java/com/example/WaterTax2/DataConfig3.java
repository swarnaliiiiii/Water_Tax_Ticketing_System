package com.example.WaterTax2;
import jakarta.persistence.*;

@Entity
@Table(name = "extended_info_table")

public class DataConfig3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_no")
    private Long serialNo;
    @Column(name = "propertyId")

    private Long propertyId;
    @Column(name = "mobileNumber")

    private String mobileNumber;
    @Column(name = "personName")

    private String personName;
    @Column(name = "email")

    private String email;
    @Column(name = "connectionType")

    private String connectionType;
    @Column(name = "plotNo")

    private String plotNo;
    @Column(name = "gali")

    private String gali;
    @Column(name = "colony")

    private String colony;
    @Column(name = "city")

    private String city;
    @Column(name = "ward")

    private Integer ward;
    @Column(name = "zone")

    private Integer zone;
    @Column(name = "pinCode")

    private String pinCode;
    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "water_type")
    private String waterType;

    private String randomNumber;

    public Long getSerialNo() {
        return serialNo;
    }


    public void setSerialNo(Long serialNo) {
        this.serialNo = serialNo;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public String getGali() {
        return gali;
    }

    public void setGali(String gali) {
        this.gali = gali;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getWard() {
        return ward;
    }

    public void setWard(Integer ward) {
        this.ward = ward;
    }

    public Integer getZone() {
        return zone;
    }

    public void setZone(Integer zone) {
        this.zone = zone;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getWaterType() {
        return waterType;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }
}
