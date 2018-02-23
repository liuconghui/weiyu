package com.lhny.fishguard.controller;


import com.alibaba.fastjson.JSONObject;
import com.lhny.fishguard.constant.MobileConstant;

import com.lhny.fishguard.exception.ServiceException;
import com.lhny.fishguard.service.IDeviceService;
import com.lhny.fishguard.service.IMemberService;
import com.lhny.fishguard.service.ITangkouService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;



import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by panzhichao on 2017/12/18.
 */
@Controller("mobileController")
public class MobileController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired private IMemberService memberService;
    @Autowired private IDeviceService deviceService;
    @Autowired private ITangkouService tangkouService;
    //获取天气
    @RequestMapping("app/getweather.do")
    @ResponseBody
    public Map<String,Object> getweather(String city)throws Exception{
        Map<String,Object> map =  new HashMap<String,Object>();
        //参数化url
        city =java.net.URLEncoder.encode(city,"UTF-8");
        //拼地址
        //String apiUrl = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s",city);
        String apiUrl =  "http://wthrcdn.etouch.cn/weather_mini?city="+city;
        //开始请求
        //System.out.println(apiUrl);
        URL url = new URL(apiUrl);
        URLConnection open =  url.openConnection();
        InputStream input =  open.getInputStream();
        String result = org.apache.commons.io.IOUtils.toString(input,"UTF-8");
        map.put("code",0);
        map.put("data",result);
        map.put("msg","获取成功");
        map.put("totalnum",1);
        return  map;
    }

    //获取塘口首页信息
    @RequestMapping("app/pondlist.do")
    @ResponseBody
    public  Map<String,Object> pondlist(String memberid)  {
        List<Map<String,String>>list;
        Map<String,String> map =  new HashMap<String,String>();
        Map<String,Object> map2 =  new HashMap<String,Object>();
        List<Map<String,Object>>list1 =  new ArrayList<Map<String, Object>>();
        map.put("memberid",memberid);

        try {
            list = tangkouService.findTangkou(map);
        } catch (ServiceException e) {
            logger.error("ִ使用MobileController方法pondlist,查询塘口出错",e);
            map2.put("code",-1);
            map2.put("data",null);
            map2.put("msg","获取失败，请检查塘口");
            map2.put("totalnum",0);
            return map2;
        }
        for(Map<String,String> map1:list){
            Map<String,Object> mp =  new HashMap<String,Object>();
            mp.put("id",map1.get("id"));
            mp.put("name",map1.get("name"));
            map.put("tangkouid",map1.get("id"));
            try {
               int allnum = deviceService.icheckall(map);
               mp.put("allnum",allnum);
               int rightnum = deviceService.icheckright(map);
               mp.put("rightnum",rightnum);
               int errornum = deviceService.icheckerror(map);
               mp.put("errornum",errornum);
               list1.add(mp);
            } catch (ServiceException e) {
                logger.error("ִ使用MobileController方法pondlist,查询设备数量出错",e);
                map2.put("code",-1);
                map2.put("data",null);
                map2.put("msg","获取失败，请检查设备数量信息");
                map2.put("totalnum",0);
                return map2;
            }
        }

        map2.put("code",0);
        map2.put("data",list1);
        map2.put("msg","获取成功");
        map2.put("totalnum",list1.size());

        return  map2;
    }
    //获取首页塘口修改信息
    @RequestMapping("app/getPondInfo.do")
    @ResponseBody
    public Map<String,Object> getPondInfo(String id){
        //List<Map<String,Object>>list =  new ArrayList<Map<String, Object>>();
        Map<String,Object> map =  new HashMap<String,Object>();
        Map<String,String> mp ;

        try {
            mp =tangkouService.findTangkouByid(id);
        } catch (ServiceException e) {
            logger.error("ִ使用MobileController方法getPondInfo,查询塘口修改信息出错",e);
            map.put("code",-1);
            map.put("data",null);
            map.put("msg","获取塘口信息失败");
            map.put("totalnum",0);
            return map;
        }
        map.put("code",0);
        map.put("data",mp);
        map.put("msg","获取塘口信息成功");
        map.put("totalnum",1);
        return map;
    }

    //提交修改塘口信息
    @RequestMapping("app/modifypond.do")
    @ResponseBody
    public Map<String,Object> modifypond(String id,String name,String length,String area,String fishtypeid,String density,String photo){
       // List<Map<String,Object>>list =  new ArrayList<Map<String, Object>>();
        Map<String,Object> map =  new HashMap<String,Object>();
        Map<String,String> mp =  new HashMap<String,String>();
        mp.put("id",id);
        mp.put("name",name);
        mp.put("length",length);
        mp.put("area",area);
        mp.put("fishtypeid",fishtypeid);
        mp.put("density",density);
        mp.put("photo",photo);
        try {
            tangkouService.modifyTangkou(mp);
        } catch (ServiceException e) {
            logger.error("ִ使用MobileController方法modifypond,修改塘口信息出错",e);
            map.put("code",-1);
            map.put("data",null);
            map.put("msg","修改失败");
            map.put("totalnum",0);
            return map;
        }
        map.put("code",0);
        map.put("data",null);
        map.put("msg","修改成功");
        map.put("totalnum",0);
        return map;
    }

    //删除首页塘口信息
    @RequestMapping("app/removepond.do")
    @ResponseBody
    public Map<String,Object> removepond(String id){
        Map<String,Object> map =  new HashMap<String,Object>();
        try {
            tangkouService.removeTangkou(id);
        } catch (ServiceException e) {
            logger.error("ִ使用MobileController方法removepond,删除塘口信息出错",e);
            map.put("code",-1);
            map.put("data",null);
            map.put("msg","删除失败");
            map.put("totalnum",0);
            return map;
        }
        map.put("code",0);
        map.put("data",null);
        map.put("msg","删除成功");
        map.put("totalnum",0);
        return map;
    }

    //提交添加塘口信息
    @RequestMapping("app/addpond.do")
    @ResponseBody
    public Map<String,Object> addpond(String name,String length,String area,String fishtypeid,String density,String photo,String memberid){
        Map<String,Object> map =  new HashMap<String,Object>();
        Map<String,String> mp =  new HashMap<String,String>();
            mp.put("name",name);
            mp.put("length",length);
            mp.put("area",area);
            mp.put("fishtypeid",fishtypeid);
            mp.put("density",density);
            mp.put("photo",photo);
            mp.put("memberid",memberid);
        try {
            tangkouService.addTangkou(mp);
        } catch (ServiceException e) {
            logger.error("ִ使用MobileController方法addpond,添加塘口信息出错",e);
            map.put("code",-1);
            map.put("data",null);
            map.put("msg","添加失败");
            map.put("totalnum",0);
            return map;
        }
        map.put("code",-1);
        map.put("data",null);
        map.put("msg","添加成功");
        map.put("totalnum",0);
        return map;
    }

    //塘口信息查看
    @RequestMapping("app/showpond.do")
    @ResponseBody
    public Map<String,Object> showpond(String tangkouid){
        List<Map<String,Object>>list =  new ArrayList<Map<String, Object>>();
        List<Map<String,String>>list1;
        Map<String,Object> map =  new HashMap<String,Object>();
        Map<String,Object> map1 =  new HashMap<String,Object>();
            map1.put("id",tangkouid);
        Map<String,String> mp =  new HashMap<String,String>();
            mp.put("tangkouid",tangkouid);
        try {
            list1 = deviceService.findDeviceEqu(mp);
        } catch (ServiceException e) {
            map.put("code",-1);
            map.put("data",null);
            map.put("msg","塘口信息查询失败");
            map.put("totalnum",0);
            return map;
        }
        for(Map<String,String> mp1:list1){
            Map<String,Object> mp2 =  new HashMap<String,Object>();
                mp2.put("id",mp1.get("id"));
                mp2.put("name",mp1.get("name"));
                mp2.put("state",mp1.get("state"));
                mp2.put("safe",mp1.get("upperThreshold"));
                mp2.put("danger",mp1.get("downThreshold"));
                mp2.put("switchMode",mp1.get("switch"));
            //最新水温和溶氧
                mp2.put("now","15.2");
                mp2.put("waterTemperature","10");
            list.add(mp2);
        }
        map1.put("device",list);
        map1.put("devicetotalnum",list1.size());

        Map<String,Object> mp2 =  new HashMap<String,Object>();
        List<String>list2 = new ArrayList<String>();
            list2.add("1-1");
            list2.add("1-2");
            list2.add("1-3");
            list2.add("1-4");
            list2.add("1-5");
        mp2.put("date",list2);
        list2 = new ArrayList<String>();
            list2.add("10");
            list2.add("12");
            list2.add("10");
            list2.add("15");
            list2.add("12");
        mp2.put("waterTemperature",list2);
        list2 = new ArrayList<String>();
            list2.add("10.1");
            list2.add("12.1");
            list2.add("10.1");
            list2.add("15.1");
            list2.add("12.1");
        mp2.put("rongyang",list2);
        map1.put("devicedetail",mp2);

        list =  new ArrayList<Map<String, Object>>();
        mp2 =  new HashMap<String,Object>();
            mp2.put("event","增氧机开机时间");
            mp2.put("time","2018年1月29日16:08:29");
        list.add(mp2);
        mp2 =  new HashMap<String,Object>();
            mp2.put("event","增氧机关机时间");
            mp2.put("time","2018年1月29日16:08:40");
        list.add(mp2);
        map1.put("log",list);

        map.put("code",1);
        map.put("data",map1);
        map.put("msg","查询成功");
        map.put("totalnum",0);
        return map;
    }

    //设备手动开关按钮
    @RequestMapping("app/deviceswitch.do")
    @ResponseBody
    public Map<String,Object> deviceswitch(String pondid,String deviceid,String switches){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,String> mp =  new HashMap<String,String>();
            mp.put("id",deviceid);
            mp.put("tangkouid",pondid);
            mp.put("switch",switches);
        String msg;
        try {
            msg = deviceService.iswitches(mp);
        } catch (ServiceException e) {
            map.put("code",-1);
            map.put("data",null);
            map.put("msg","修改失败");
            map.put("totalnum",0);
            return  map;
        }
        map.put("code",1);
        map.put("data",null);
        map.put("msg",msg);
        map.put("totalnum",0);
        return  map;
    }

    //设备设置按钮
    @RequestMapping("app/deviceshow.do")
    @ResponseBody
    public Map<String,Object> deviceshow(String deviceid){
        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,String> mp =  new HashMap<String,String>();
        mp.put("id",deviceid);
        try {
            mp = deviceService.findEquipmentConfigurationByid(deviceid);
        } catch (ServiceException e) {
            map.put("code",-1);
            map.put("data",null);
            map.put("msg","查询失败");
            map.put("totalnum",0);
            return  map;
        }
        map.put("code",1);
        map.put("data",mp);
        map.put("msg","查询成功");
        map.put("totalnum",0);
        return  map;
    }

    //用户登陆
    @RequestMapping("app/memberlanding.do")
    @ResponseBody
    public Map<String,Object> memberlanding(String code) throws IOException {

        Map<String,Object> map = new HashMap<String, Object>();
        Map<String,String> mp = new HashMap<String, String>();
        List<Map<String,String>> list;
       /* System.out.println("code="+code);
        System.out.println("appid="+appid);*/
       if(code==null||"".equals(code.trim())){
           map.put("code",-1);
           map.put("data",null);
           map.put("msg","code不能为空");
           map.put("totalnum",0);
           return map;
       }
        //拼地址
        String apiUrl =  "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+ java.net.URLEncoder.encode(MobileConstant.appid,"UTF-8")
                        +"&secret="+java.net.URLEncoder.encode(MobileConstant.secret,"UTF-8")
                        +"&code="+java.net.URLEncoder.encode(code,"UTF-8")+"&grant_type=authorization_code";
        //开始请求
       // System.out.println(apiUrl);
        URL url = new URL(apiUrl);
        URLConnection open =  url.openConnection();
        InputStream input =  open.getInputStream();
        String result = org.apache.commons.io.IOUtils.toString(input,"UTF-8");
       // System.out.println(result);access_token  expires_in refresh_token openid scope unionid
        JSONObject json = JSONObject.parseObject(result);

        apiUrl = "https://api.weixin.qq.com/sns/userinfo?access_token="
                +java.net.URLEncoder.encode(json.get("access_token").toString(),"UTF-8")
                +"&openid="+java.net.URLEncoder.encode(json.get("openid").toString(),"UTF-8");
        url = new URL(apiUrl);
        open =  url.openConnection();
        input =  open.getInputStream();
        result = org.apache.commons.io.IOUtils.toString(input,"UTF-8");
        json = JSONObject.parseObject(result);
        //System.out.println(result);openid nickname sex language city province country  headimgurl privilege unionid

        //List<Map<String,Object>>list =  new ArrayList<Map<String, Object>>();
        //根据code查询 如果已存在，查询是否绑定手机号，如果没有返回参数到APP端
        mp.put("openid",json.get("openid").toString());
        int num ;
        try {
            num = memberService.findMemberCount(mp);
            //System.out.println(num);
        } catch (ServiceException e) {
            logger.error("ִ使用MobileController方法memberlanding检查code出错",e);
            map.put("code",-1);
            map.put("data",null);
            map.put("msg","code检查出错");
            map.put("totalnum",0);
            return map;
        }
        if(num==0){
            String id ;
            mp.put("phone","");
            mp.put("wd1","");
            mp.put("wd2","");
            mp.put("wd3","");
            mp.put("wd4","");
            mp.put("wd5","");
            try {
                id =memberService.addMember(mp);
            } catch (ServiceException e) {
                logger.error("ִ使用MobileController方法memberlanding添加member信息出错",e);
                map.put("code",-1);
                map.put("data",null);
                map.put("msg","注册用户出错");
                map.put("totalnum",0);
                return map;
            }
            mp.put("id",id);
            mp.put("nickname",json.get("nickname").toString());
            mp.put("headimgurl",json.get("headimgurl").toString());
            map.put("code",1);
            map.put("data",mp);
            map.put("msg","已初步绑定微信信息，手机号未绑定");
            map.put("totalnum",0);
        }else if(num==1){
            try {
                list = memberService.findMember(mp);
            } catch (ServiceException e) {
                logger.error("ִ使用MobileController方法memberlanding查询member信息出错",e);
                map.put("code",-1);
                map.put("data",null);
                map.put("msg","会员信息查询异常");
                map.put("totalnum",0);
                return map;
            }
            mp = list.get(0);
            mp.put("nickname",json.get("nickname").toString());
           // System.out.print(mp);
            if(mp.get("phone")==null){
                map.put("code",1);
                map.put("data",mp);
                map.put("msg","手机号未绑定");
                map.put("totalnum",0);
            }else{
                if("".equals(mp.get("phone").trim())){
                    map.put("code",1);
                    map.put("data",mp);
                    map.put("msg","手机号未绑定1");
                    map.put("totalnum",0);
                }else{
                    map.put("code", 0);
                    map.put("data", mp);
                    map.put("msg", "查询成功");
                    map.put("totalnum", 1);
                }
            }
        }else{
            map.put("code",-1);
            map.put("data",null);
            map.put("msg","账号绑定失败");
            map.put("totalnum",0);
        }

        return map;
    }

    //获取手机验证码
    @RequestMapping("app/getidcode.do")
    @ResponseBody
    public Map<String,Object> getidcode(String phone){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("data",null);
        map.put("msg","");
        map.put("totalnum",0);
        return map;
    }

    //验证手机验证码
    @RequestMapping("app/checkidcode.do")
    @ResponseBody
    public Map<String,Object> checkidcode(String phone,String password){
        Map<String,Object> map = new HashMap<String, Object>();
        if(password.equals("1234")){
            map.put("code",0);
            map.put("data",null);
            map.put("msg","验证码输入成功");
            map.put("totalnum",0);
        }else{
            map.put("code",-1);
            map.put("data",null);
            map.put("msg","验证码输入错误");
            map.put("totalnum",0);
        }
        return map;
    }

    //关于我们
    @RequestMapping("aboutus.do")
    public String aboutus(){
        return "pages/app/AboutUs";
    }
}
