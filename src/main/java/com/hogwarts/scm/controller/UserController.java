package com.hogwarts.scm.controller;

import com.hogwarts.scm.base.result.PageTableRequest;
import com.hogwarts.scm.base.result.Results;
import com.hogwarts.scm.dao.UserDao;
import com.hogwarts.scm.dto.UserDto;
import com.hogwarts.scm.model.SysUser;
import com.hogwarts.scm.service.UserService;
import com.hogwarts.scm.util.MD5;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("/{username}")
    @ResponseBody
    @CrossOrigin(value = "http://localhost:3000", maxAge = 1800, allowedHeaders = "*")
    public SysUser user(@PathVariable String username) {
        log.info("UserController.user(): param ( username =" + username + " ) ");
        return userService.getUser(username);
    }

    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin(value = "http://localhost:3000", maxAge = 1800, allowedHeaders = "*")
    public String updateuser(@RequestBody JSONObject userinfo) {

        SysUser sysUser = new SysUser();
        sysUser =userService.updateUser(userinfo.getString("username"), userinfo.getString("password"));
        String username = userinfo.getString("username");
        String password = userinfo.getString("password");
        System.out.println("Front: " + password);
        System.out.println("End: " + sysUser.getPassword());
        if (password.equals(sysUser.getPassword()) ) {
           return "success";
        }
        else
        {
           return "fail";
        }
    }

    @RequestMapping("/list")
    @ResponseBody
    public Results<SysUser> getUsers(PageTableRequest pageTableRequest) {
        pageTableRequest.countOffset();
        return userService.getAllUserbyPage(pageTableRequest.getOffset(), pageTableRequest.getLimit());
    }

    @RequestMapping("/add")
    public String addUser(Model model) {
        model.addAttribute(new SysUser()); // 与user-add.html中${sysUser.name}对应
        return "user/user-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public Results<SysUser> saveUser(UserDto userDto, Integer roleId) {
        userDto.setStatus(1);
        userDto.setPassword(MD5.crypt(userDto.getPassword()));
        System.out.println(userDto.toString()+roleId);
        return userService.save(userDto, roleId);
    }

    String pattern = "yyyy-MM-dd";
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat(pattern), true));
    }

}
