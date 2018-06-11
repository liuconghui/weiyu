package com.lhny.fishguard.dao.impl;

import com.lhny.fishguard.dao.EmployeeDao;
import com.lhny.fishguard.dao.RolenamelistDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("employeeDao")
    public class RolenamelistDaoImpl implements RolenamelistDao {

    public List<Map<String,String>> rolenamelist() throws DataAccessException {
        return null;
        }
}
