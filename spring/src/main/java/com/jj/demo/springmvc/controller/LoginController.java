package com.jj.demo.springmvc.controller;

import com.jj.demo.springmvc.constant.Global;
import com.jj.demo.springmvc.db.entity.User;
import com.jj.demo.springmvc.exception.MyException;
import com.jj.demo.springmvc.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by panjunjie on 2016/07/21.
 */
@Controller
public class LoginController extends BaseController{

    @Resource
    LoginService service;

    @Resource
    HttpServletRequest request;//代表用户的请求，用户每次发过来的请求都会传过来一个request

    @RequestMapping("/exception")
    public void exception() throws Exception{
        throw new MyException("触发异常测试");
    }

    @RequestMapping("/loginpage")
    public String toLoginPage(){
        return "WEB-INF/jsp/login.jsp";
    }
    @RequestMapping("/user/home")
    public String toUserHome(){
        return "/WEB-INF/jsp/userhome.jsp";
    }

    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    public String doLogin(@RequestParam String userName,@RequestParam String password){
        /*String loginPageUrl="WEB-INF/jsp/login.jsp";
        String successPageUrl="WEB-INF/jsp/success.jsp";
        String uname=request.getParameter("uname");
        String upasswd=request.getParameter("upasswd");*/
        try{
            User user = service.doLogin(userName,password);
            request.getSession().setAttribute(Global.USER_SESSION_KEY,user);
            return "/WEB-INF/jsp/userhome.jsp";
        }catch (Exception e){
            return "/WEB-INF/jsp/login.jsp";
        }
       //.service.doLogin(loginPageUrl,successPageUrl,uname,upasswd);
    }

}
