package com.lhny.fishguard.service.impl;


import com.lhny.fishguard.dao.EmployeeDao;
import com.lhny.fishguard.dao.RolenamelistDao;
import com.lhny.fishguard.exception.ServiceException;
import com.lhny.fishguard.service.IRolenamelistService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("rolenamelistService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=ServiceException.class)
public class RolenamelistServiceImpl implements IRolenamelistService {
    @Autowired private RolenamelistDao rolenamelistDao;
    private Logger logger=Logger.getLogger(this.getClass());
    public List<Map<String,String>> rolenamelist() throws ServiceException {

        return rolenamelistDao.rolenamelist();
    }

}
