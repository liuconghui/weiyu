package com.lhny.fishguard.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface DeviceDao {

    /**
     * 添加设备信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param Map<String,String> map
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void insertDevice(Map<String,String> map)throws DataAccessException;

    /**
     * 删除设备信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String deviceid
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void deleteDevice(String id)throws DataAccessException;

    /**
     * 修改设备信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void updateDevice(Map<String,String> map)throws DataAccessException;

    /**
     * 条件查询（查询所有/根据设备名称，状态，软件/硬件版本，出厂编号，设备购买时间，会员id，设备维护人查询）所有设备信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return List<Map<String,String>>
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public List<Map<String,String>> selectDevice(Map<String,String> map)throws DataAccessException;


    /**
     * 根据id查询设备信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return Map<String,String>
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public Map<String,String> selectDeviceByid(String id)throws DataAccessException;

    /**
     * 检查主键id
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return int
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public int checkDeviceId(String id)throws DataAccessException;

    /**
     * 检查异常数量
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String memberid,tangkouid
     * @return int
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public int checkerror(Map<String,String> map)throws DataAccessException;

    /**
     * 检查总数量
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String memberid,tangkouid
     * @return int
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public int checkall(Map<String,String> map)throws DataAccessException;

    /**
     * 检查正常数量
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String memberid,tangkouid
     * @return int
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public int checkright(Map<String,String> map)throws DataAccessException;

    /**
     * 开关功能
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String deviceid,tangkouid
     * @return int
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void switches(Map<String,String> map)throws DataAccessException;

    /**
     * 条件查询（查询所有/根据设备名称，状态，软件/硬件版本，出厂编号，设备购买时间，会员id，设备维护人查询）所有设备信息以及配置信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return List<Map<String,String>>
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public List<Map<String,String>> selectDeviceEqu(Map<String,String> map)throws DataAccessException;
}
