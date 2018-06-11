package com.lhny.fishguard.dao.impl;

import com.lhny.fishguard.dao.EmployeeDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository("employeeDao")
    public class EmployeeDaoImpl implements EmployeeDao {

    public List<Map<String,String>> findEmployee() throws DataAccessException {
        return null;
        }
    public  void addemployee(Map map) throws DataAccessException {

    }
}
