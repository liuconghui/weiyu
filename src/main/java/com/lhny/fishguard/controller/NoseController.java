package com.lhny.fishguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoseController {
	@RequestMapping("advert.do")
	public String advert(){
		return "pages/nose/advert/advertmain";
	}
	
	@RequestMapping("advertquery.do")
	public String advertquery(){
		return "pages/nose/advert/advertquery";
	}
	
	@RequestMapping("adsensequery.do")
	public String adsensequery(){
		return "pages/nose/advert/adsensequery";
	}
	
	@RequestMapping("configuration.do")
	public String configuration(){
		return "pages/nose/configuration/configurationmain";
	}
	
	@RequestMapping("configurationquery.do")
	public String configurationquery(){
		return "pages/nose/configuration/configurationquery";
	}
	
	@RequestMapping("tangkou.do")
	public String tangkou(){
		return "pages/nose/tangkou/tangkoumain";
	}
	
	@RequestMapping("tangkouquery.do")
	public String tangkouquery(){
		return "pages/nose/tangkou/tangkouquery";
	}
	
	@RequestMapping("member.do")
	public String member(){
		return "pages/nose/member/membermain";
	}
	
	@RequestMapping("memberquery.do")
	public String memberquery(){
		return "pages/nose/member/memberquery";
	}
	
	@RequestMapping("notice.do")
	public String notice(){
		return "pages/nose/notice/noticemain";
	}
	
	@RequestMapping("noticequery.do")
	public String noticequery(){
		return "pages/nose/notice/noticequery";
	}
	
	@RequestMapping("feedback.do")
	public String feedback(){
		return "pages/nose/feedback/feedbackmain";
	}
	
	@RequestMapping("feedbackquery.do")
	public String feedbackquery(){
		return "pages/nose/feedback/feedbackquery";
	}
}
