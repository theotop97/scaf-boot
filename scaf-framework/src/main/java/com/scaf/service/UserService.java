package com.scaf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scaf.domain.entity.User;
import com.scaf.service.business.vo.UserVo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

public interface UserService extends IService<User> {


    UserVo getUser();
}
