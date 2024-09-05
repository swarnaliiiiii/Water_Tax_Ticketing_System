package com.example.WaterTax2.Service;
import com.example.WaterTax2.DataConfig;
import com.example.WaterTax2.DataConfig3;
import com.example.WaterTax2.Repository.DataRepo3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataService3 {

    @Autowired
    private DataRepo3 dataRepo3;
    public List<DataConfig3> findAllData() {
        return dataRepo3.findAll();
    }

    public DataConfig3 findDataById(Long waterId) {
        return dataRepo3.findById(waterId).orElse(null);
    }

    public DataConfig3 createData(DataConfig3 dataConfig3) {
        return dataRepo3.save(dataConfig3);
    }


    public DataConfig3 updateData(Long Serial_no, DataConfig3 dataConfig3) {
        DataConfig3 existingData = findDataById(Serial_no);
        if (existingData != null) {
            existingData.setPropertyId(dataConfig3.getPropertyId());
            existingData.setMobileNumber(dataConfig3.getMobileNumber());
            existingData.setMobileNumber(dataConfig3.getMobileNumber());
            existingData.setPersonName(dataConfig3.getPersonName());
            existingData.setEmail(dataConfig3.getEmail());
            existingData.setConnectionType(dataConfig3.getConnectionType());
            existingData.setMobileNumber(dataConfig3.getMobileNumber());
            existingData.setWard(dataConfig3.getWard());
            existingData.setZone(dataConfig3.getZone());
            existingData.setPlotNo(dataConfig3.getPlotNo());
            existingData.setGali(dataConfig3.getGali());
            existingData.setCity(dataConfig3.getCity());
            existingData.setPinCode(dataConfig3.getPinCode());
            existingData.setPropertyType(dataConfig3.getPropertyType());
            existingData.setWaterType(dataConfig3.getWaterType());
            return dataRepo3.save(existingData);
        } else {
            return null;
        }
    }


}
