package com.lhny.fishguard.dao.impl;

import com.lhny.fishguard.dao.DeviceDao;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public class DeviceDaoImpl implements DeviceDao {

    public void insertDevice(Map<String, String> map) throws DataAccessException {
    }

    public void deleteDevice(String tangkouid) throws DataAccessException {

    }

    public void updateDevice(Map<String, String> map) throws DataAccessException {

    }

    public List<Map<String, String>> selectDevice(Map<String, String> map) throws DataAccessException {
        return null;
    }

    public Map<String, String> selectDeviceByid(String Tangkouid) throws DataAccessException {
        return null;
    }

    public int checkDeviceId(String id) throws DataAccessException {
        return 0;
    }

    public int checkall(Map<String, String> map) throws DataAccessException {
        return 0;
    }

    public int checkerror(Map<String, String> map) throws DataAccessException {
        return 0;
    }

    public int checkright(Map<String, String> map) throws DataAccessException {
        return 0;
    }

    public void switches(Map<String, String> map) throws DataAccessException {
    }

    public List<Map<String, String>> selectDeviceEqu(Map<String, String> map) throws DataAccessException {
        return null;
    }
}
