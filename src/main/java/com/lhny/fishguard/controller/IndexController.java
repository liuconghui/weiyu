package com.lhny.fishguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("index.do")
	public String index(){
		return "pages/index";
	}
	
	@RequestMapping("left.do")
	public String left(){
		return"pages/left";
	}
	
	@RequestMapping("content.do")
	public String content(){
		return"pages/content";
	}
	
	@RequestMapping("foot.do")
	public String foot(){
		return"pages/foot";
	}
}
