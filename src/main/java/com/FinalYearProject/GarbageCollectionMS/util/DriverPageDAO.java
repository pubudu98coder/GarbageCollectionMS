package com.FinalYearProject.GarbageCollectionMS.util;

import com.FinalYearProject.GarbageCollectionMS.dao.DriverDAO;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class DriverPageDAO {
    private List<DriverDAO> driverList;
    private int count;
}