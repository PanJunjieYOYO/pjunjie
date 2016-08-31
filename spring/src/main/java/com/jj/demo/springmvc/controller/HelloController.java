package com.jj.demo.springmvc.controller;

import com.jj.demo.springmvc.db.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by panjunjie on 2016/07/27.
 */
@Controller
@RequestMapping(value = "/jj")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String list(ModelMap model){
        System.out.println("aaa");
        model.addAttribute("message","Hello world!");
        return "login";
    }

    @RequestMapping(value = "page/{name}/{age}",method = RequestMethod.GET)
    public String getName(ModelMap map, @PathVariable("name") String name, @PathVariable("age") String age){

        map.addAttribute("name",name);
        map.addAttribute("age",age);
        return "name";
    }

}
