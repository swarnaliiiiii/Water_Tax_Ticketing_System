package com.example.WaterTax2;

import jakarta.persistence.*;


@Entity
@Table(name = "new_table")
public class DataConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "water_id")
    private Long waterId;
    @Column(name = "Username")
    private String Username;
    @Column(name = "ward")
    private int Ward;
    @Column(name = "zone")
    private int Zone;
    @Column(name = "address")
    private String address;
    @Column(name = "mobile_no")
    private Long mobile_no;
    @Column(name = "old_con_id")
    private String old_con_id;

    @Column(name = "property_id")
    private String property_id;

    @Column(name = "plot_no")
    private String plotNo;

    @Column(name = "gali")
    private String gali;

    @Column(name = "colony")
    private String colony;

    @Column(name = "city")
    private String city;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(name = "property_type")
    private String propertyType;

    @Column(name = "water_type")
    private String waterType;

    private String randomNumber;

    // Getters and Setter

    public Long getWater_id() {
        return waterId;
    }

    public void setWater_id(Long water_id) {
        this.waterId = water_id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public int getWard() {
        return Ward;
    }

    public void setWard(int Ward) {
        this.Ward = Ward;
    }

    public int getZone() {
        return Zone;
    }

    public void setZone(int Zone) {
        this.Zone = Zone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(Long mobile_no) {
        this.mobile_no = mobile_no;
    }
    public String getOld_con_id() {
        return old_con_id;
    }

    public void setOld_con_id(String old_con_id) {
        this.old_con_id = old_con_id;
    }

    public String getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(String randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getProperty_id() {
        return property_id;
    }

    public void setProperty_id(String property_id) {
        this.property_id = property_id;
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

}
