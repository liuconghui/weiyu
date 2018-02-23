package com.lhny.fishguard.dao.impl;

import com.lhny.fishguard.dao.EquipmentConfigurationDao;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public class EquipmentConfigurationDaoImpl implements EquipmentConfigurationDao {

    public void insertEquipmentConfiguration(Map<String, String> map) throws DataAccessException {
    }

    public void updateEquipmentConfiguration(Map<String, String> map) throws DataAccessException {

    }

    public void deleteEquipmentConfiguration(String equipmentConfigurationid) throws DataAccessException {

    }

    public List<Map<String, String>> selectEquipmentConfiguration(Map<String, String> map) throws DataAccessException {
        return null;
    }

    public Map<String, String> selectEquipmentConfigurationByid(String id) throws DataAccessException {
        return null;
    }

    public int checkEquipmentConfigurationId(String id) throws DataAccessException {
        return 0;
    }
}
