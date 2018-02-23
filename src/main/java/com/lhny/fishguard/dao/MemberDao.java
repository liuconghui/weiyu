package com.lhny.fishguard.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

public interface MemberDao {
    /**
     * 添加会员
     * <一句话功能简述>
     * <功能详细描述>
     * @param Map<String,String> map
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void insertMember(Map<String,String> map)throws DataAccessException;

    /**
     * 删除会员
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void deleteMember(String id)throws DataAccessException;

    /**
     * 修改会员信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public void updateMember(Map<String,String> map)throws DataAccessException;

    /**
     * 条件查询（手机号，code，openid）所有会员信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return List<Map<String,String>>
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public List<Map<String,String>> selectMember(Map<String,String> map)throws DataAccessException;

    /**
     * 检查重复（code,手机号）
     * <一句话功能简述>
     * <功能详细描述>
     * @param  Map<String,String> map
     * @return List<Map<String,String>>
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public int selectMemberCount(Map<String,String> map)throws DataAccessException;

    /**
     * 根据id查询会员信息
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return Map<String,String>
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public Map<String,String> selectMemberByid(String id)throws DataAccessException;

    /**
     * 检查主键id
     * <一句话功能简述>
     * <功能详细描述>
     * @param  String id
     * @return int
     * @throws DataAccessException
     * @see [类、类#方法、类#成员]
     */
    public int checkMemberId(String id)throws DataAccessException;

}
