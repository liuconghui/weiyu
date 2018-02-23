package com.lhny.fishguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SalesController {
	
	@RequestMapping("devicetype.do")
	public String devicetype(){
		return "pages/sales/devicetype/devicetypemain";
	}
	
	@RequestMapping("devicetypequery.do")
	public String devicetypequery(){
		return "pages/sales/devicetype/devicetypequery";
	}
	
	@RequestMapping("device.do")
	public String device(){
		return "pages/sales/device/devicemain";
	}
	
	@RequestMapping("devicequery.do")
	public String devicequery(){
		return "pages/sales/device/devicequery";
	}
	
	@RequestMapping("stock.do")
	public String stock(){
		return "pages/sales/stock/stockmain";
	}
	
	@RequestMapping("stockquery.do")
	public String stockquery(){
		return "pages/sales/stock/stockquery";
	}
}
