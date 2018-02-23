package com.lhny.fishguard.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface EquipmentConfigurationDao {
    /**
     * 添加设备配置信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param Map<String,String> map
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void insertEquipmentConfiguration(Map<String,String> map)throws DataAccessException;

    /**
     * 修改设备配置信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param Map<String,String> map
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void updateEquipmentConfiguration(Map<String,String> map)throws DataAccessException;

    /**
     * 删除设备配置信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param String id
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void deleteEquipmentConfiguration(String id)throws DataAccessException;

    /**
     * 根据id查询设备配置信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String equipmentConfigurationid
     * @return Map<String,String>
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public Map<String,String> selectEquipmentConfigurationByid(String id)throws DataAccessException;

    /**
     * 检查主键id
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return int
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public int checkEquipmentConfigurationId(String id)throws DataAccessException;
}
