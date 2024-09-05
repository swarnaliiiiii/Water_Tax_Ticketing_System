package com.example.WaterTax2.controller;

import com.example.WaterTax2.DataConfig;
import com.example.WaterTax2.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/dataconfig")
public class controller{

    @Autowired
    private DataService dataService;

    @GetMapping("")
    public List<DataConfig> getAllData() {
        return dataService.findAllData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataConfig> getDataById(@PathVariable("id") Long waterId) {
        DataConfig dataConfig = dataService.findDataById(waterId);
        if (dataConfig != null) {
            return ResponseEntity.ok(dataConfig);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    @GetMapping("/apply.html")
    public String apply() {
        return "apply";
    }
    @GetMapping("/track.html")
    public String track() {
        return "track";
    }
    @GetMapping("/CF.html")
    public String CF() {
        return "CF";
    }
    @GetMapping("/payment.html")
    public String payment() {
        return "payment";
    }
    @PostMapping
    public ResponseEntity<DataConfig> createData(@RequestBody DataConfig dataConfig) {
        DataConfig createdData = dataService.createData(dataConfig);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdData);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataConfig> updateData(@PathVariable("id") Long waterId, @RequestBody DataConfig dataConfig) {
        DataConfig updatedData = dataService.updateData(waterId, dataConfig);
        if (updatedData != null) {
            return ResponseEntity.ok(updatedData);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteData(@PathVariable("id") Long waterId) {
        boolean isDeleted = dataService.deleteData(waterId);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<DataConfig>> search(
            @RequestParam(value = "water_id", required = false) Long waterId,
            @RequestParam(value = "Ward", required = false) Integer ward,
            @RequestParam(value = "Zone", required = false) Integer zone,
            @RequestParam(value = "Username", required = false) String username,
            @RequestParam(value = "mobile_no", required = false) Long mobileNo,
            @RequestParam(value = "old_con_id", required = false) String oldConId,
            @RequestParam(value = "address", required = false) String address) {

        List<DataConfig> results = dataService.search(waterId, ward, zone, username, mobileNo, oldConId, address);

        return ResponseEntity.ok(results);
    }

}
