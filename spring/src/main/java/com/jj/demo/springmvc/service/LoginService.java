package com.jj.demo.springmvc.service;

import com.jj.demo.springmvc.dao.LoginDao;
import com.jj.demo.springmvc.db.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by panjunjie on 2016/07/21.
 */
@Service
public class LoginService {
    /*public ModelAndView doLogin(String loginPageUrl, String successPageUrl, String uname, String upasswd) {

        if(uname==null||"".equals(uname)){
            return new ModelAndView(loginPageUrl,"error","用户名不能为空");
        }
        if(upasswd==null||"".equals(upasswd)){
            return new ModelAndView(loginPageUrl,"error","密码不能为空");
        }

        if(uname.equals("admin")&&upasswd.equals("123")){
            return new ModelAndView(successPageUrl);
        }

        return new ModelAndView(loginPageUrl,"error","用户名或者密码错误");
    }*/
    @Resource
    LoginDao dao ;

    public User doLogin(String username, String password) throws Exception {

        if (username == null || "".equals(username)) {
            throw new Exception("用户名不能为空");
        }

        if (password == null || "".equals(password)) {
            throw new Exception("密码不能为空");
        }

        User user = dao.selectByUserName(username);
        if (user == null) {
            throw new Exception("账号不存在");
        }

        if (!user.getPassword().equals(password)) {
            throw new Exception("密码不正确");
        }

        return user;
    }
}
