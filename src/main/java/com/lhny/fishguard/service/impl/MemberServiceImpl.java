package com.lhny.fishguard.service.impl;

import com.lhny.fishguard.dao.MemberDao;
import com.lhny.fishguard.exception.ServiceException;
import com.lhny.fishguard.service.IMemberService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=ServiceException.class)
public class MemberServiceImpl implements IMemberService{
    @Autowired
    private MemberDao memberDao;
    private Logger logger=Logger.getLogger(this.getClass());
    //检查id
    public String checkid()throws ServiceException{
        UUID uuid = UUID.randomUUID();
        String id = "MB"+uuid.toString();
        int num = -1;
        try {
            num =memberDao.checkMemberId(id);
        }catch (Exception e){
            logger.error("ִ使用MemberServiceImpl中的checkid方法出错",e);
            throw new ServiceException("数据库操作异常，检查会员id失败");
        }
        if(num==0){
            return  id;
        }else if(num==1){
            id=checkid();
            return id;
        }
        logger.error("ִ使用MemberServiceImpl中的checkid方法出错");
        throw new ServiceException("数据库操作异常，检查会员id出现多个相同id，id为'" + id + "'");
    }
    //添加
    @Transactional(propagation=Propagation.REQUIRED)
    public String addMember(Map<String, String> map) throws ServiceException{
        String id =  checkid();
        map.put("id",id);
        Date date = new Date();
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
        String creattime = sdf.format(date);
        map.put("creattime",creattime);
        map.put("state","0");
       // System.out.println(map);
        try {
            memberDao.insertMember(map);
        }catch (Exception e){
            logger.error("ִ使用MemberServiceImpl中的addMember方法出错");
            throw new ServiceException("数据库操作异常，添加会员数据失败");
        }
        return id;
    }
    //修改
    @Transactional(propagation=Propagation.REQUIRED)
    public void modifyMember(Map<String, String> map) throws ServiceException{
        try {
            memberDao.updateMember(map);
        }catch (Exception e){
            logger.error("ִ使用MemberServiceImpl中的modifyMember方法出错");
            throw new ServiceException("数据库操作异常，更新数据失败");
        }
    }
    //删除
    @Transactional(propagation=Propagation.REQUIRED)
    public void removeMember(String id) throws ServiceException{
        try {
            memberDao.deleteMember(id);
        }catch (Exception e){
            logger.error("ִ使用MemberServiceImpl中的removeMember方法出错");
            throw new ServiceException("数据库操作异常，删除会员数据失败");
        }
    }
//检查重复（code,手机号）
    public int findMemberCount(Map<String, String> map) throws ServiceException{
        int num ;
        try {
            num = memberDao.selectMemberCount(map);
            System.out.println(map);
        }catch (Exception e){
            logger.error("ִ使用MemberServiceImpl中的findMemberCount方法出错");
            throw new ServiceException("数据库操作异常，检查重复数据失败");
        }
        return num;
    }
//查询所有条件查询（手机号，code，openid）所有会员信息
    public List<Map<String, String>> findMember(Map<String, String> map) throws ServiceException{
        List<Map<String,String>> list;
        try {
           list =  memberDao.selectMember(map);
        }catch (Exception e){
            logger.error("ִ使用MemberServiceImpl中的findMember方法出错");
            throw new ServiceException("数据库操作异常，条件查询所有数据数据失败");
        }
        return list;
    }

    public Map<String, String> findMemberByid(String id) throws ServiceException{
        Map<String,String> map;
        try {
            map = memberDao.selectMemberByid(id);
        }catch (Exception e){
            logger.error("ִ使用MemberServiceImpl中的findMemberByid方法出错");
            throw new ServiceException("数据库操作异常，条件查询所有数据数据失败");
        }
        return map;
    }
}
