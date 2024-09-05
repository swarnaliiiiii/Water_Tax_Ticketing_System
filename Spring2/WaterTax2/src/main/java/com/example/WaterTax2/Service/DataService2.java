package com.example.WaterTax2.Service;

import com.example.WaterTax2.DataConfig2;
import com.example.WaterTax2.Repository.DataRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService2 {
    @Autowired
    private DataRepo2 dataRepo2;

    public boolean existsByPropertyId(Long propertyId) {
        return dataRepo2.existsByPropertyId(propertyId);
    }
}
