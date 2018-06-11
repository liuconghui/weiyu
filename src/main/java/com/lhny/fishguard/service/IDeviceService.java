package com.lhny.fishguard.service;


import com.lhny.fishguard.exception.ServiceException;
import com.lhny.fishguard.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface IDeviceService {
    /**
     * 添加设备信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param Map<String,String> map
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public String addDevice(Map<String,String> map)throws ServiceException;

    /**
     * 删除设备信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public void removeDevice(String id)throws ServiceException;

    /**
     * 修改设备信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public void modifyDevice(Map<String,String> map)throws ServiceException;

    /**
     * 修改设备配置信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public void modifyEquipmentConfiguration(Map<String,String> map)throws ServiceException;

    /**
     * 条件查询（查询所有/根据设备名称，状态，软件/硬件版本，出厂编号，设备购买时间，会员id，设备维护人查询）所有设备信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return List<Map<String,String>>
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public List<Map<String,String>> findDevice(Map<String,String> map)throws ServiceException;


    /**
     * 根据id查询设备信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return Map<String,String>
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public Map<String,String> findDeviceByid(String id)throws ServiceException;

    /**
     * 检查异常数量
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String memberid,tangkouid
     * @return int
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public int icheckerror(Map<String,String> map)throws ServiceException;

    /**
     * 检查总数量
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String memberid,tangkouid
     * @return int
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public int icheckall(Map<String,String> map)throws ServiceException;

    /**
     * 检查正常数量
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String memberid,tangkouid
     * @return int
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public int icheckright(Map<String,String> map)throws ServiceException;

    /**
     * 开关功能
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String deviceid,tangkouid
     * @return int
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public String iswitches(Map<String,String> map)throws ServiceException;

    /**
     * 条件查询（查询所有/根据设备名称，状态，软件/硬件版本，出厂编号，设备购买时间，会员id，设备维护人查询）所有设备信息以及配置信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return List<Map<String,String>>
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public List<Map<String,String>> findDeviceEqu(Map<String,String> map)throws ServiceException;


    /**
     * 根据id查询设备配置信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String equipmentConfigurationid
     * @return Map<String,String>
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public Map<String,String> findEquipmentConfigurationByid(String id)throws ServiceException;
}
