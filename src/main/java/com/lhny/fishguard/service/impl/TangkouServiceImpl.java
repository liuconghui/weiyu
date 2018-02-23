package com.lhny.fishguard.service.impl;

import com.lhny.fishguard.dao.TangkouDao;
import com.lhny.fishguard.exception.ServiceException;
import com.lhny.fishguard.service.ITangkouService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service("tangkouService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=ServiceException.class)
public class TangkouServiceImpl implements ITangkouService{

    @Autowired private TangkouDao tangkouDao;
    private Logger logger=Logger.getLogger(this.getClass());

    public String checkid()throws ServiceException{
        UUID uuid=UUID.randomUUID();
        String id = "TK"+uuid.toString();
        int num = -1;
        try {
            num = tangkouDao.checkTangkouId(id);
        }catch (Exception e){
            logger.error("ִ使用TangkouServiceImpl中的checkid方法出错",e);
            throw new ServiceException("数据库操作异常，检查塘口id失败");
        }
        if(num==0){
            return id;
        }else if(num==1){
            id = checkid();
            return id;
        }
        logger.error("ִ使用TangkouServiceImpl中的checkid方法出错");
        throw new ServiceException("数据库操作异常，检查塘口id出现多个相同id，id为'" + id + "'");
    }

    @Transactional(propagation= Propagation.REQUIRED)
    public String addTangkou(Map<String, String> map) throws ServiceException{
        String id =  checkid();
        map.put("id",id);
        Date date = new Date();
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
        String creattime = sdf.format(date);
        map.put("creattime",creattime);
        map.put("state","0");
        map.put("pump","");
        map.put("probe","");
        map.put("electricity","");
        map.put("dissolvedOxygen","");
        map.put("wd4","");
        map.put("wd5","");
        try {
            tangkouDao.insertTangkou(map);
        }catch (Exception e){
            logger.error("ִ使用TangkouServiceImpl中的addTangkou方法出错");
            throw new ServiceException("数据库操作异常，添加塘口数据失败");
        }
        return id;
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void removeTangkou(String id) throws ServiceException{
        try {
            tangkouDao.deleteTangkou(id);
        }catch (Exception e){
            logger.error("ִ使用TangkouServiceImpl中的removeTangkou方法出错");
            throw new ServiceException("数据库操作异常，删除塘口数据失败");
        }
    }

    @Transactional(propagation=Propagation.REQUIRED)
    public void modifyTangkou(Map<String, String> map) throws ServiceException{
        try {
            tangkouDao.updateTangkou(map);
        }catch (Exception e){
            logger.error("ִ使用TangkouServiceImpl中的modifyTangkou方法出错");
            throw new ServiceException("数据库操作异常，修改塘口数据失败");
        }
    }

    public List<Map<String, String>> findTangkou(Map<String, String> map) throws ServiceException{
        List<Map<String,String>> list;
        try {
            list = tangkouDao.selectTangkou(map);
        }catch (Exception e){
            logger.error("ִ使用TangkouServiceImpl中的findTangkou方法出错");
            throw new ServiceException("数据库操作异常，条件查询塘口数据失败");
        }
        return list;
    }

    public Map<String, String> findTangkouByid(String id) throws ServiceException{
        Map<String, String> map;
        try {
            map = tangkouDao.selectTangkouByid(id);
        }catch (Exception e){
            logger.error("ִ使用TangkouServiceImpl中的findTangkouByid方法出错");
            throw new ServiceException("数据库操作异常，id查询塘口数据失败");
        }
        return map;
    }
}
