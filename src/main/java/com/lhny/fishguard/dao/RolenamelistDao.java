package com.lhny.fishguard.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface RolenamelistDao {

    public List<Map<String,String>> rolenamelist() throws DataAccessException;


}
