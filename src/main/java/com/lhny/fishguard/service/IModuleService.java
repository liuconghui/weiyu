package com.lhny.fishguard.service;

import java.util.List;
import java.util.Map;

import com.lhny.fishguard.exception.ServiceException;

public interface IModuleService {
	/**
	 * 添加模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param  Map
	 * @return 
	 * @throws ServiceException
	 * @see [类、类#方法、类#成员]
	 */
	public void addModule(Map<String,String> map)throws ServiceException;
	
	/**
	 * 删除模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param  String id
	 * @return 
	 * @throws ServiceException
	 * @see [类、类#方法、类#成员]
	 */
	public void removeModule(String id)throws ServiceException;
	
	/**
	 * 修改模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param  Map<String,String>map
	 * @return 
	 * @throws ServiceException
	 * @see [类、类#方法、类#成员]
	 */
	public void modifyModule(Map<String,String> map)throws ServiceException;
	
	/**
	 * 查询模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param  Map
	 * @return Map
	 * @throws ServiceException
	 * @see [类、类#方法、类#成员]
	 */
	public List<Map<String,String>> findModule(Map<String,String> map)throws ServiceException;
	
/**
	 * 根据id查询模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param  Map
	 * @return Map
	 * @throws ServiceException
	 * @see [类、类#方法、类#成员]
	 */
	public Map<String,String> findModuleByid(String id)throws ServiceException;

	/**
	 * 查询父模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param
	 * @return List<Map<String,String>>
	 * @throws ServiceException
	 * @see [类、类#方法、类#成员]
	 */
	public List<Map<String,String>> findModulefid()throws ServiceException;

}
