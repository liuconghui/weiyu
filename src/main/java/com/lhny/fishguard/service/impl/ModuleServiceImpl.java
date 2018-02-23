package com.lhny.fishguard.service.impl;

import java.util.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lhny.fishguard.dao.ModuleDao;
import com.lhny.fishguard.exception.ServiceException;
import com.lhny.fishguard.service.IModuleService;

@Service("moduleService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=ServiceException.class)
public class ModuleServiceImpl implements IModuleService{

	@Autowired
	private ModuleDao moduleDao;
	private Logger logger=Logger.getLogger(this.getClass());
	
//检查并生成需要的id
	public String checkid() throws ServiceException{
		UUID uuid=UUID.randomUUID();
		String id = "MD"+uuid.toString();
		int num = -1;
		try {
			num =moduleDao.checkModuleId(id);
		} catch (Exception e) {
			logger.error("ִ使用ModuleServiceImpl中的checkid方法出错",e);
			throw new ServiceException("数据库操作异常，检查模块id失败");
		}
		if(num==0){
			return id;
		}else if(num==1){
			id = checkid();
			return id;
		}
			logger.error("ִ使用ModuleServiceImpl中的checkid方法出错");
			throw new ServiceException("数据库操作异常，检查模块id出现多个相同id，id为'" + id + "'");

	}
	
//增加	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addModule(Map<String, String> map) throws ServiceException {
		String id = checkid();
		map.put("id", id);
		try {
			moduleDao.insertModule(map);
		} catch (Exception e) {
			logger.error("ִ使用ModuleServiceImpl中的addModule方法出错");
			throw new ServiceException("数据库操作异常，添加数据失败");
		}
	}
	
//删除
	@Transactional(propagation=Propagation.REQUIRED)
	public void removeModule(String id) throws ServiceException {
		try {
			moduleDao.deleteModule(id);
		} catch (Exception e) {
			logger.error("ִ使用ModuleServiceImpl中的removeModule方法出错");
			throw new ServiceException("数据库操作异常，删除数据失败");
		}
		
	}
	
//修改
	@Transactional(propagation=Propagation.REQUIRED)
	public void modifyModule(Map<String, String> map) throws ServiceException {
		try {
			moduleDao.updateModule(map);
		} catch (Exception e) {
			logger.error("ִ使用ModuleServiceImpl中的modifyModule方法出错");
			throw new ServiceException("数据库操作异常，修改数据失败");
		}
		
	}
	
//查询所有 通过fid
	public List<Map<String,String>> findModule(Map<String, String> map)
			throws ServiceException {
		List<Map<String,String>> list ;
		try {
			list= moduleDao.selectModule(map);
		} catch (Exception e) {
			logger.error("ִ使用ModuleServiceImpl中的findModule方法出错");
			throw new ServiceException("数据库操作异常，查询数据失败");
		}
		return list;
	}
	
//通过id查询
	public Map<String, String> findModuleByid(String id)
			throws ServiceException {
		Map<String, String> map;
		try {
			map = moduleDao.selectModuleByid(id);
		} catch (Exception e) {
			logger.error("ִ使用ModuleServiceImpl中的findModuleByid方法出错");
			throw new ServiceException("数据库操作异常，通过id查询数据失败");
		}
		return map;
	}

	public List<Map<String,String>> findModulefid() throws ServiceException {
		List<Map<String,String>> list;
		try {
			list = moduleDao.selectModulefid();
		}catch (Exception e){
			logger.error("ִ使用ModuleServiceImpl中的findModulefid方法出错");
			throw new ServiceException("数据库操作异常，查询父模块失败");
		}

		return list;
	}
}
