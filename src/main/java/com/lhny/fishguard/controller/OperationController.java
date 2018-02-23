package com.lhny.fishguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperationController {

	@RequestMapping("charmonitor.do")
	public String charmonitor(){
		return "pages/operate/charmonitor/charmonitormain";
	}

	@RequestMapping("monitor.do")
	public String monitor(){
		return "pages/operate/monitor/monitormain";
	}

	@RequestMapping("monitorquerymember.do")
	public String monitorquerymember(){
		return "pages/operate/monitor/monitorquerymember";
	}

	@RequestMapping("monitorquerydetails.do")
	public String monitorquerydetails(){
		return "pages/operate/monitor/monitorquerydetails";
	}

	@RequestMapping("querykhpz.do")
	public String querykhpz(){
		return "pages/operate/monitor/querykhpz";
	}

	@RequestMapping("querysbrz.do")
	public String querysbrz(){
		return "pages/operate/monitor/querysbrz";
	}

	@RequestMapping("querytksb.do")
	public String querytksb(){
		return "pages/operate/monitor/querytksb";
	}

	@RequestMapping("queryqxt.do")
	public String queryqxt(){
		return "pages/operate/monitor/queryqxt";
	}

	@RequestMapping("querytqxx.do")
	public String querytqxx(){
		return "pages/operate/monitor/querytqxx";
	}

	@RequestMapping("querygjrz.do")
	public String querygjrz(){
		return "pages/operate/monitor/querygjrz";
	}
}
