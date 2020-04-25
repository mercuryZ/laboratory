package com.hogwarts.laboratory.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hogwarts.laboratory.model.SysUser;
import com.hogwarts.laboratory.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    @ResponseBody
    @CrossOrigin(value = "http://localhost:3000", maxAge = 1800, allowedHeaders = "*")
    public SysUser user(@PathVariable String username) {
        log.info("UserController.user(): param ( username =" + username + " ) ");
        return userService.getUser(username);
    }

    @PostMapping("/updateuser")
    @ResponseBody
    @CrossOrigin(value = "http://localhost:3000", maxAge = 1800, allowedHeaders = "*")
    public String updateuser(@RequestBody JSONObject userinfo) {
        userService.updateUser(userinfo.getString("username"), userinfo.getString("password"));
        return "success";
    }
}
