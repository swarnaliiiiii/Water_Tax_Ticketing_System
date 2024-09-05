package com.example.WaterTax2.Service;

import com.example.WaterTax2.DataConfig;
import com.example.WaterTax2.DataConfig2;
import com.example.WaterTax2.Repository.DataRepo;
import com.example.WaterTax2.Repository.DataRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DataService {

    @Autowired
    private DataRepo dataRepo;

    @Autowired
    private DataRepo2 dataRepo2;

    public List<DataConfig> findAllData() {
        return dataRepo.findAll();
    }

    public DataConfig findDataById(Long waterId) {
        return dataRepo.findById(waterId).orElse(null);
    }

    public DataConfig createData(DataConfig dataConfig) {
        return dataRepo.save(dataConfig);
    }

    public DataConfig updateData(Long waterId, DataConfig dataConfig) {
        DataConfig existingData = findDataById(waterId);
        if (existingData != null) {
            existingData.setWater_id(dataConfig.getWater_id());
            existingData.setUsername(dataConfig.getUsername());
            existingData.setWard(dataConfig.getWard());
            existingData.setZone(dataConfig.getZone());
            existingData.setAddress(dataConfig.getAddress());
            existingData.setMobile_no(dataConfig.getMobile_no());
            existingData.setOld_con_id(dataConfig.getOld_con_id());
            return dataRepo.save(existingData);
        } else {
            return null;
        }
    }

    public boolean deleteData(Long waterId) {
        DataConfig dataConfig = findDataById(waterId);
        if (dataConfig != null) {
            dataRepo.deleteById(waterId);
            return true;
        }
        return false;
    }

    public List<DataConfig> search(Long waterId, Integer ward, Integer zone, String username, Long mobileNo, String oldConId, String address) {
        Specification<DataConfig> spec = Specification.where(null);

        if (waterId != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("waterId"), waterId));
        }
        if (ward != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("Ward"), ward));
        }
        if (zone != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("Zone"), zone));
        }
        if (username != null) {
            spec = spec.and((root, query, cb) -> cb.like(root.get("Username"), "%" + username + "%"));
        }
        if (mobileNo != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("mobile_no"), mobileNo));
        }
        if (oldConId != null) {
            spec = spec.and((root, query, cb) -> cb.like(root.get("old_con_id"), "%" + oldConId + "%"));
        }
        if (address != null) {
            spec = spec.and((root, query, cb) -> cb.like(root.get("address"), "%" + address + "%"));
        }

        return dataRepo.findAll(spec);
    }

    public boolean existsByPropertyId(Long propertyId) {
        return dataRepo2.existsByPropertyId(propertyId);
    }


}

