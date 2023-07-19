package com.scaf.controller;

import com.scaf.domain.entity.User;
import com.scaf.service.UserService;
import com.scaf.service.business.vo.UserVo;
import com.scaf.service.exception.UserException;
import com.scaf.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "user模块")
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "test接口，获取所有user信息")
    @GetMapping("/test")
    public List<User> test() {
        logger.error("------------------");
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

    @GetMapping("/getredis")
    public Object getRedis() {
        return redisUtil.get("hello");
    }
}
