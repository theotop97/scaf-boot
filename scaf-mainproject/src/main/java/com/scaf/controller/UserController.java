package com.scaf.controller;

import com.scaf.domain.entity.User;
import com.scaf.service.UserService;
import com.scaf.service.business.vo.PageVo;
import com.scaf.service.business.vo.UserVo;
import com.scaf.service.exception.UserException;
import com.scaf.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "user模块")
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
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

    @ApiOperation(value = "根据id查询user信息")
    @GetMapping("/getUser")
    public UserVo getUser(@ApiParam(value = "id") Long id) {
        return userService.getUser(id);
    }

    @ApiOperation(value = "分页获取所有user信息")
    @GetMapping("/getUserList")
    public PageVo getUserList(@ApiParam(value = "页数") Integer pageNum,
                              @ApiParam(value = "每页数量") Integer pageSize,
                              @ApiParam(value = "id") Long id) {
        return userService.getUserList(pageNum, pageSize, id);

    }

    @ApiOperation(value = "redis测试类")
    @GetMapping("/getredis")
    public Object getRedis() {
        return redisUtil.get("hello");
    }
}
