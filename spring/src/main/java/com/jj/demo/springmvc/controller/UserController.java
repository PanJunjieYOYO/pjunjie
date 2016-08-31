package com.jj.demo.springmvc.controller;

import com.jj.demo.springmvc.db.DbConnection;
import com.jj.demo.springmvc.db.entity.User;
import com.jj.demo.springmvc.db.entity.UsersEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by panjunjie on 2016/07/30.
 */
@Controller
public class UserController {

    @RequestMapping(value = "users",method = RequestMethod.GET)
    public  String listUsers(ModelMap map){
        Session session= DbConnection.getSession();

        List<UsersEntity> list=session.createCriteria(UsersEntity.class).addOrder(Order.desc("id")).list();

        map.addAttribute("users",list);

        session.close();
        return "users";
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.GET)
    public String addUser(ModelMap map){
        User u=new User();
        u.setName("jjo1");

        map.addAttribute("user",u);

        return "add_user";
    }
    @RequestMapping(value = "result",method =RequestMethod.POST)
    public String result(ModelMap map, @RequestParam String name, @RequestParam int age, HttpServletRequest request, HttpServletResponse response){
        map.addAttribute("name",name);
        map.addAttribute("age",age);

        Session session=DbConnection.getSession();
        Transaction transaction = session.beginTransaction();

        UsersEntity ue=new UsersEntity();
        ue.setName(name);
        ue.setAge((byte) age);
        session.save(ue);

        transaction.commit();
        session.close();

       /* try {
            response.sendRedirect("users");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return "result";
    }

}
