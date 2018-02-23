package com.lhny.fishguard.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface TangkouDao {
    /**
     * 添加塘口信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param Map<String,String> map
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void insertTangkou(Map<String,String> map)throws DataAccessException;

    /**
     * 删除塘口信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String tangkouid
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void deleteTangkou(String id)throws DataAccessException;

    /**
     * 修改塘口信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void updateTangkou(Map<String,String> map)throws DataAccessException;

    /**
     * 条件查询（名称 状态）所有塘口信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map (name state)
     * @return List<Map<String,String>>
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public List<Map<String,String>> selectTangkou(Map<String,String> map)throws DataAccessException;


    /**
     * 根据id查询塘口信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return Map<String,String>
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public Map<String,String> selectTangkouByid(String id)throws DataAccessException;

    /**
     * 检查主键id
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return int
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public int checkTangkouId(String id)throws DataAccessException;
}
