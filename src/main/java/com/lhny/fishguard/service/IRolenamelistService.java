package com.lhny.fishguard.service;


import com.lhny.fishguard.exception.ServiceException;

import java.util.List;
import java.util.Map;

public interface IRolenamelistService {
    /**
     * 发现
     * <一句话功能简述>
     * <功能详细描述>
     * @param Map<String,String> map
     * @return
     * @throws ServiceException
     * @see [类、类#方法、类#成员]
     */
    public  List<Map<String,String>>  rolenamelist()throws ServiceException;
}

