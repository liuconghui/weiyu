package com.lhny.fishguard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lhny.fishguard.service.IEmployeeService;
import com.lhny.fishguard.service.IRolenamelistService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lhny.fishguard.exception.ServiceException;
import com.lhny.fishguard.service.IModuleService;
import com.lhny.fishguard.service.IEmployeeService;
@Controller
public class BackstageController {
	@Autowired private IModuleService moduleService;
	@Autowired private IEmployeeService employeeService;
	@Autowired private IRolenamelistService rolenamelistService;
	private Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping("module.do")
	public ModelAndView module(){
		Map<String,List> map =  new HashMap<String,List>();
		List<Map<String,String>>list = new ArrayList<Map<String, String>>();
		try {
			list = moduleService.findModulefid();
			map.put("fnamelist",list);
		}catch (Exception e){
			logger.error("ִ使用BackstageController方法module出错",e);
		}
		return new ModelAndView("pages/backstage/module/modulemain",map);
	}
	
	@RequestMapping("modulequery.do")
	public ModelAndView modulequery(String name,String fid){
		List<Map<String,String>>list =  new ArrayList<Map<String,String>>();
		Map map =  new HashMap<String,String>();
		if(null!=name&&!"".equals(name.trim())){
			map.put("name", name);
		}
		if(null!=fid&&!"".equals(fid.trim())){
			map.put("fid", fid);
		}
		try {
			list = moduleService.findModule(map);
			map = new HashMap();
			map.put("modulelist",list);
		} catch (ServiceException e) {
			logger.error("ִ使用BackstageController方法modulequery出错",e);
		}
		return new ModelAndView("pages/backstage/module/modulequery",map);
	}
	@RequestMapping("moduleadd.do")
	public ModelAndView moduleadd(){
		Map map =  new HashMap();
		List<Map<String,String>>list =  new ArrayList<Map<String,String>>();
		try {
			list = moduleService.findModule(map);
			for(int i=0;i<list.size();i++){
				if(null==list.get(i).get("id")||"".equals(list.get(i).get("id").trim())){
					if(null==list.get(i).get("name")||"".equals(list.get(i).get("name").trim())){
						list.remove(i);
					}
				}
			}
			map =  new HashMap<String,List>();
			map.put("modulename",list);

		}catch (Exception e){
			logger.error("ִ使用BackstageController方法moduleadd出错",e);
		}
		return new ModelAndView("pages/backstage/module/moduleadd",map);
	}
	
	@RequestMapping("addmodule.do")
	public String addmodule(String name){

		return "";
	}
	@RequestMapping("area.do")
	public String area(){
		return "pages/backstage/area/areamain";
	}
	
	@RequestMapping("areaquery.do")
	public String areaquery(){
		return "pages/backstage/area/areaquery";
	}
	
	@RequestMapping("role.do")
	public String role(){
		return "pages/backstage/role/rolemain";
	}
	
	@RequestMapping("rolequery.do")
	public String rolequery(){
		return "pages/backstage/role/rolequery";
	}
	
	@RequestMapping("repository.do")
	public String repository(){
		return "pages/backstage/repository/repositorymain";
	}
	
	@RequestMapping("employee.do")
	public String employee(){
		return "pages/backstage/employee/employeemain";
	}

	@RequestMapping("employeeadd.do")
	public String employeeadd(){
		return "pages/backstage/employee/employeeadd";
	}

	@RequestMapping("employeequery.do")
	public ModelAndView employeequery(){
		List<Map<String,String>>list =  new ArrayList<Map<String,String>>();
		Map map =  new HashMap<String,String>();
		try {
			list = employeeService.findEmployee();
			map = new HashMap();
			map.put("employeelist",list);
		} catch (ServiceException e) {
			logger.error("ִ使用BackstageController方法employeequery出错",e);
		}
		return new ModelAndView("pages/backstage/employee/employeequery",map);
	}

	@RequestMapping("rolenamelist.do")
	@ResponseBody
	public Map rolenamelist(){
		System.out.println("11111111111111");
		List<Map<String,String>>list =  new ArrayList<Map<String,String>>();
		Map map =  new HashMap<String,String>();
		try {
			list =  rolenamelistService.rolenamelist();
            map=new HashMap();
			map.put("rolenamelist",list);
		} catch (ServiceException e) {
			logger.error("ִ使用BackstageController方法 rolenamlitsl出错",e);
		}

		return map;
	}

	//提交添加employeeadd信息
	@RequestMapping("employeeaddsave.do")
	@ResponseBody
	public ModelAndView employeeadd(String name,String phone,String role,String hiredate){
		Map<String,Object> map =  new HashMap<String,Object>();
		Map<String,String> mp =  new HashMap<String,String>();
		mp.put("name",name);
		mp.put("phone", phone);
		mp.put("role",role);
		mp.put("hiredate",hiredate);
		try {
			employeeService.addemployee(mp);
		} catch (Exception e) {
			logger.error("ִ使用backstaeeController方法addpond,添加employeeadd信息出错", e);

		}
       map.put("code",-1);
	   map.put("data",null);
	   map.put("msg","添加成功");
		return new ModelAndView("pages/backstage/employee/employeemain",map);
	}


	@RequestMapping("workorder.do")
	public String workorder(){
		return "pages/backstage/workorder/workordermain";
	}
	
	@RequestMapping("workorderquery.do")
	public String workorderquery(){
		return "pages/backstage/workorder/workorderquery";
	}
}
