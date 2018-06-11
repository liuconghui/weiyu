package com.lhny.fishguard.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface EmployeeDao {

    public List<Map<String,String>> findEmployee()throws DataAccessException;

    void addemployee(Map map);
}
