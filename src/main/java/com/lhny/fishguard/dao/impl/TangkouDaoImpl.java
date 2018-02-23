package com.lhny.fishguard.dao.impl;

import com.lhny.fishguard.dao.TangkouDao;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public class TangkouDaoImpl implements TangkouDao{

    public void insertTangkou(Map<String, String> map) throws DataAccessException {
    }

    public void deleteTangkou(String memberid) throws DataAccessException {

    }

    public void updateTangkou(Map<String, String> map) throws DataAccessException {

    }

    public List<Map<String, String>> selectTangkou(Map<String, String> map) throws DataAccessException {
        return null;
    }

    public Map<String, String> selectTangkouByid(String Tangkouid) throws DataAccessException {
        return null;
    }

    public int checkTangkouId(String id) throws DataAccessException {
        return 0;
    }
}
