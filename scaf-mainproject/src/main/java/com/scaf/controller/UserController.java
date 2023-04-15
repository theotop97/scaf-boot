package com.scaf.controller;

import com.scaf.domain.entity.User;
import com.scaf.service.UserService;
import com.scaf.service.business.vo.UserVo;
import com.scaf.service.exception.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public List<User> test() {
        List<User> list = userService.list();
        if (list.isEmpty()) {
            throw UserException.notFound();
        }
        return list;
    }

    @GetMapping("/getuser")
    public UserVo getUser() {
        return userService.getUser();
    }
}
