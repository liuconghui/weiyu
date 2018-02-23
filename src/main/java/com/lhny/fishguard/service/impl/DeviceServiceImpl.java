package com.lhny.fishguard.service.impl;

import com.lhny.fishguard.dao.DeviceDao;
import com.lhny.fishguard.dao.EquipmentConfigurationDao;
import com.lhny.fishguard.exception.ServiceException;
import com.lhny.fishguard.service.IDeviceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("deviceService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=ServiceException.class)
public class DeviceServiceImpl implements IDeviceService {

    @Autowired private DeviceDao deviceDao;
    @Autowired private EquipmentConfigurationDao equipmentConfigurationDao;
    private Logger logger=Logger.getLogger(this.getClass());

    //检查id
    public String checkid()throws ServiceException{
        UUID uuid = UUID.randomUUID();
        String id = "De"+uuid.toString();
        int num = -1;
        try {
            num =deviceDao.checkDeviceId(id);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的checkid方法出错",e);
            throw new ServiceException("数据库操作异常，检查设备id失败");
        }
        if(num==0){
            return  id;
        }else if(num==1){
            id=checkid();
            return id;
        }
        logger.error("ִ使用DeviceServiceImpl中的checkid方法出错");
        throw new ServiceException("数据库操作异常，检查设备id出现多个相同id，id为'" + id + "'");
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public String addDevice(Map<String, String> map) throws ServiceException{
        String id =  checkid();
        map.put("id",id);
        map.put("state","0");
        map.put("switch","0");
        try {
            deviceDao.insertDevice(map);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的addDevice方法出错",e);
            throw new ServiceException("数据库操作异常，添加设备信息失败");
        }
        map.put("switchMode","0");
        map.put("upperThreshold","0");
        map.put("downThreshold","0");
        map.put("isopen","0");
        map.put("closetime","");
        map.put("opentime","");
        map.put("wd1","");
        map.put("wd2","");
        map.put("wd3","");
        map.put("wd4","");
        map.put("wd5","");
        try {
            equipmentConfigurationDao.insertEquipmentConfiguration(map);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的addDevice方法出错",e);
            throw new ServiceException("数据库操作异常，添加设备配置信息失败");
        }
        return id;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void removeDevice(String id) throws ServiceException{
        try {
            deviceDao.deleteDevice(id);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的removeDevice方法出错",e);
            throw new ServiceException("数据库操作异常，删除设备信息失败");
        }
        try {
            equipmentConfigurationDao.deleteEquipmentConfiguration(id);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的removeDevice方法出错",e);
            throw new ServiceException("数据库操作异常，删除设备配置信息失败");
        }
    }
    @Transactional(propagation=Propagation.REQUIRED)
    public void modifyDevice(Map<String, String> map) throws ServiceException{
        try {
            deviceDao.updateDevice(map);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的modifyDevice方法出错",e);
            throw new ServiceException("数据库操作异常，修改设备信息失败");
        }
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void modifyEquipmentConfiguration(Map<String, String> map) throws ServiceException{
        try {
            equipmentConfigurationDao.updateEquipmentConfiguration(map);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的modifyDevice方法出错",e);
            throw new ServiceException("数据库操作异常，修改设备配置信息失败");
        }
    }

    public List<Map<String, String>> findDevice(Map<String, String> map) throws ServiceException{
        List<Map<String, String>>list ;
        try {
            list = deviceDao.selectDevice(map);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的findDevice方法出错",e);
            throw new ServiceException("数据库操作异常，条件查询设备信息失败");
        }
        return list;
    }

    public Map<String, String> findDeviceByid(String id) throws ServiceException{
        Map<String, String> map ;
        try {
            map = deviceDao.selectDeviceByid(id);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的findDeviceByid方法出错",e);
            throw new ServiceException("数据库操作异常，id查询设备配置信息失败");
        }
        return null;
    }

    public int icheckall(Map<String, String> map) throws ServiceException{
        int num;
        try {
            num=deviceDao.checkall(map);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的icheckall方法出错",e);
            throw new ServiceException("数据库操作异常，查询所有信息失败");
        }
        return num;
    }

    public int icheckerror(Map<String, String> map) throws ServiceException{
        int num;
        try {
            num=deviceDao.checkerror(map);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的icheckerror方法出错",e);
            throw new ServiceException("数据库操作异常，查询错误信息失败");
        }
        return num;
    }

    public int icheckright(Map<String, String> map) throws ServiceException{
        int num;
        try {
            num=deviceDao.checkright(map);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的icheckright方法出错",e);
            throw new ServiceException("数据库操作异常，查询正确信息失败");
        }
        return num;
    }

    public String iswitches(Map<String, String> map) throws ServiceException{
        List<Map<String, String>>list ;
        try {
            list = deviceDao.selectDevice(map);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的iswitches方法出错",e);
            throw new ServiceException("数据库操作异常，查询设备信息失败");
        }
        if(list.size()==0){
            return "未查询到对应的设备";
        }else if(list.size()==1){
            try {
                deviceDao.switches(map);
            }catch (Exception e){
                logger.error("ִ使用DeviceServiceImpl中的iswitches方法出错",e);
                throw new ServiceException("数据库操作异常，修改设备开关信息失败");
            }
            return "修改成功";
        }else{
            return "修改失败";
        }
    }

    public List<Map<String, String>> findDeviceEqu(Map<String, String> map) throws ServiceException{
        List<Map<String, String>>list ;
        try {
            list = deviceDao.selectDeviceEqu(map);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的findDeviceEqu方法出错",e);
            throw new ServiceException("数据库操作异常，条件查询设备配置信息失败");
        }
        return list;
    }

    public Map<String, String> findEquipmentConfigurationByid(String id) throws ServiceException{
        Map<String, String>map;
        try {
            map = equipmentConfigurationDao.selectEquipmentConfigurationByid(id);
        }catch (Exception e){
            logger.error("ִ使用DeviceServiceImpl中的findEquipmentConfigurationByid方法出错",e);
            throw new ServiceException("数据库操作异常，id查询设备配置信息失败");
        }
        return map;
    }
}
