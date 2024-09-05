package com.example.WaterTax2.controller;

import com.example.WaterTax2.DataConfig;
import com.example.WaterTax2.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/api/dataconfig2")
public class Controller2 {

    @Autowired
    private DataService dataService;

    @GetMapping("/checkPropertyId")
    public ResponseEntity<Boolean> checkPropertyId(@RequestParam("propertyId") Long propertyId) {
        boolean exists = dataService.existsByPropertyId(propertyId);
        return ResponseEntity.ok(exists);
    }

    @PostMapping("/apply")
    public ResponseEntity<String> createData(@RequestBody DataConfig dataConfig) {
        String randomNumber = "0" + (long) (Math.random() * 1_000_000_000L);
        dataConfig.setRandomNumber(randomNumber);
        dataConfig.setWater_id(Long.valueOf(randomNumber));
        String fullAddress = dataConfig.getPlotNo() + ", " +
                dataConfig.getGali() + ", " +
                dataConfig.getColony();
        dataConfig.setAddress(fullAddress);
        dataConfig.setUsername(dataConfig.getUsername());
        try {
            dataConfig.setMobile_no((dataConfig.getMobile_no()));
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid format for mobile number: " + dataConfig.getMobile_no());
        }
        dataConfig.setOld_con_id(dataConfig.getOld_con_id());
        dataConfig.setProperty_id(dataConfig.getProperty_id());
        dataConfig.setCity(dataConfig.getCity());
        dataConfig.setPinCode(dataConfig.getPinCode());
        dataConfig.setPropertyType(dataConfig.getPropertyType());
        dataConfig.setWaterType(dataConfig.getWaterType());
        try {
            dataService.createData(dataConfig);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save data to new_table");
        }

        // Return success message
        return ResponseEntity.status(HttpStatus.CREATED).body("Data successfully created with random number: " + randomNumber);
    }
    @GetMapping("/getWaterDetails")
    public ResponseEntity<?> getWaterDetails(@RequestParam("water_id") Long waterId) {
        DataConfig details = dataService.findDataById(waterId);

        if (details!=null) {
            return ResponseEntity.ok(details);
        } else {
            return ResponseEntity.status(404).body("No details found for the provided Water ID.");
        }
    }
    }
