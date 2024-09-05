package com.example.WaterTax2.Repository;

import com.example.WaterTax2.DataConfig;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DataRepo extends JpaRepository<DataConfig,Long>, JpaSpecificationExecutor<DataConfig> {
    @Query("SELECT d FROM DataConfig d WHERE d.waterId = :waterId")
    List<DataConfig> findByWaterId(@Param("waterId") Long waterId);
}
