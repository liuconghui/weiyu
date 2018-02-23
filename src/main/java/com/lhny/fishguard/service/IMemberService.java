package com.lhny.fishguard.service;

import com.lhny.fishguard.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface IMemberService {
    /**
     * 添加会员
     * <一句话功能简述>
     * <功能详细描述>
     * @param Map<String,String> map
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public String addMember(Map<String,String> map)throws ServiceException;

    /**
     * 删除会员
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public void removeMember(String id)throws ServiceException;

    /**
     * 修改会员信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public void modifyMember(Map<String,String> map)throws ServiceException;

    /**
     * 条件查询所有会员信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return List<Map<String,String>>
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public List<Map<String,String>> findMember(Map<String,String> map)throws ServiceException;

    /**
     * 检查重复（code,手机号）
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return List<Map<String,String>>
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public int findMemberCount(Map<String,String> map)throws ServiceException;

    /**
     * 根据id查询模块
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return Map<String,String>
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public Map<String,String> findMemberByid(String id)throws ServiceException;

}
