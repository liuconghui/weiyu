package com.lhny.fishguard.dao.impl;

import com.lhny.fishguard.dao.MemberDao;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public class MemberDaoImpl implements MemberDao {

    public void insertMember(Map<String, String> map) throws DataAccessException {
    }

    public void deleteMember(String memberid) throws DataAccessException {

    }

    public void updateMember(Map<String, String> map) throws DataAccessException {

    }

    public List<Map<String, String>> selectMember(Map<String, String> map) throws DataAccessException {
        return null;
    }

    public Map<String, String> selectMemberByid(String id) throws DataAccessException {
        return null;
    }

    public int checkMemberId(String id) throws DataAccessException {
        return 0;
    }

    public int selectMemberCount(Map<String, String> map) throws DataAccessException {
        return 0;
    }
}
