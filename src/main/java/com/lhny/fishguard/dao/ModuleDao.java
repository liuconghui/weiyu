package com.lhny.fishguard.dao;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface ModuleDao {
	
	/**
	 * 添加模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param Map<String,String> map
	 * @return 
	 * @throws DataAccessException
	 * @see [类、类#方法、类#成员]
	 */
	public void insertModule(Map<String,String> map)throws DataAccessException;
	
	/**
	 * 删除模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param  String id
	 * @return 
	 * @throws DataAccessException
	 * @see [类、类#方法、类#成员]
	 */
	public void deleteModule(String id)throws DataAccessException;
	
	/**
	 * 修改模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param  Map<String,String> map
	 * @return 
	 * @throws DataAccessException
	 * @see [类、类#方法、类#成员]
	 */
	public void updateModule(Map<String,String> map)throws DataAccessException;
	
	/**
	 * 查询模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param  Map<String,String> map 填写fid和名称筛选查询
	 * @return List<Map<String,String>>
	 * @throws DataAccessException
	 * @see [类、类#方法、类#成员]
	 */
	public List<Map<String,String>> selectModule(Map<String,String> map)throws DataAccessException;
	
	/**
	 * 根据id查询模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param  String id
	 * @return Map<String,String>
	 * @throws DataAccessException
	 * @see [类、类#方法、类#成员]
	 */
	public Map<String,String> selectModuleByid(String id)throws DataAccessException;
	
	/**
	 * 检查主键id
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param  String id
	 * @return int
	 * @throws DataAccessException
	 * @see [类、类#方法、类#成员]
	 */
	public int checkModuleId(String id)throws DataAccessException;

	/**
	 * 获取父模块
	 * <一句话功能简述>
	 * <功能详细描述>
	 * @param
	 * @return List<Map<String,String>>
	 * @throws DataAccessException
	 * @see [类、类#方法、类#成员]
	 */
	public List<Map<String,String>> selectModulefid()throws DataAccessException;
}
