package com.example.WaterTax2.Repository;

import com.example.WaterTax2.DataConfig2;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DataRepo2 extends JpaRepository<DataConfig2, Long> {
    boolean existsByPropertyId(Long propertyId);
}