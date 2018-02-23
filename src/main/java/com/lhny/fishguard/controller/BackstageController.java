package com.lhny.fishguard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lhny.fishguard.exception.ServiceException;
import com.lhny.fishguard.service.IModuleService;

@Controller
public class BackstageController {
	@Autowired private IModuleService moduleService;
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
	@RequestMapping("employeequery.do")
	public String employeequery(){
		return "pages/backstage/employee/employeequery";
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
