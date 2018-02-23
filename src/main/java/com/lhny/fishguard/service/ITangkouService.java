package com.lhny.fishguard.service;

import com.lhny.fishguard.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface ITangkouService {
    /**
     * 添加塘口信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param Map<String,String> map
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public String addTangkou(Map<String,String> map)throws ServiceException;

    /**
     * 删除塘口信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public void removeTangkou(String id)throws ServiceException;

    /**
     * 修改塘口信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public void modifyTangkou(Map<String,String> map)throws ServiceException;

    /**
     * 条件查询（名称，状态）所有塘口信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map （name state）
     * @return List<Map<String,String>>
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public List<Map<String,String>> findTangkou(Map<String,String> map)throws ServiceException;


    /**
     * 根据id查询塘口信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return Map<String,String>
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public Map<String,String> findTangkouByid(String id)throws ServiceException;
}
