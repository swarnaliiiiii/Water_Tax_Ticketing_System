package com.example.WaterTax2.Listener;

import com.example.WaterTax2.DataConfig;
import com.example.WaterTax2.DataConfig3;
import com.example.WaterTax2.Repository.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.persistence.PostPersist;

@Component
public class DataConfig3Listener {

    @Autowired
    private DataRepo dataRepo;

    @PostPersist
    public void afterInsert(DataConfig3 dataConfig3) {
        // Create a new instance of DataConfig (new_table)
        DataConfig newDataConfig = new DataConfig();

        // Map the fields from DataConfig3 (ExtendedInfoTable) to DataConfig (new_table)
        newDataConfig.setUsername(dataConfig3.getPersonName());
        newDataConfig.setWard(dataConfig3.getWard());
        newDataConfig.setZone(dataConfig3.getZone());
        newDataConfig.setMobile_no(Long.parseLong(dataConfig3.getMobileNumber()));
        newDataConfig.setProperty_id(String.valueOf(dataConfig3.getPropertyId()));
        newDataConfig.setPlotNo(dataConfig3.getPlotNo());
        newDataConfig.setGali(dataConfig3.getGali());
        newDataConfig.setColony(dataConfig3.getColony());
        newDataConfig.setCity(dataConfig3.getCity());
        newDataConfig.setPinCode(dataConfig3.getPinCode());
        newDataConfig.setPropertyType(dataConfig3.getPropertyType());
        newDataConfig.setWaterType(dataConfig3.getWaterType());
        newDataConfig.setRandomNumber(dataConfig3.getRandomNumber());

        // Save the populated DataConfig object into the new_table using DataRepo
        dataRepo.save(newDataConfig);
    }
}

