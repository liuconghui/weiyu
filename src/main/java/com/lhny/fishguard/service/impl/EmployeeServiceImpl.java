package com.lhny.fishguard.service.impl;


import com.lhny.fishguard.dao.EmployeeDao;
import com.lhny.fishguard.exception.ServiceException;
import com.lhny.fishguard.service.IEmployeeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service("employeeService")
@Transactional(propagation = Propagation.REQUIRED,rollbackFor=ServiceException.class)
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired private EmployeeDao employeeDao;
    private Logger logger=Logger.getLogger(this.getClass());
    public List<Map<String,String>>findEmployee(){

        return employeeDao.findEmployee();
    }
    public  void addemployee(Map map) {
         employeeDao.addemployee( map);
    }

}
