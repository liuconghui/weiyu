package com.lhny.fishguard.dao.impl;

import com.lhny.fishguard.dao.ModuleDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by panzhichao on 2017/12/14.
 */
@Repository("moduleDao")
public class ModuleDaoImpl implements ModuleDao {

    public void insertModule(Map<String, String> map) throws DataAccessException {

    }

    public void updateModule(Map<String, String> map) throws DataAccessException {

    }

    public void deleteModule(String moduleid) throws DataAccessException {

    }

    public List<Map<String, String>> selectModule(Map<String, String> map) throws DataAccessException {
        return null;
    }

    public Map<String, String> selectModuleByid(String id) throws DataAccessException {
        return null;
    }

    public int checkModuleId(String id) throws DataAccessException {
        return 0;
    }

    public List<Map<String, String>> selectModulefid() throws DataAccessException {
        return null;
    }


}
