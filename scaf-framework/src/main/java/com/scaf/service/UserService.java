package com.scaf.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.scaf.domain.entity.User;
import com.scaf.service.business.UpdateUserDto;
import com.scaf.service.business.vo.PageVo;
import com.scaf.service.business.vo.UserVo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserService extends IService<User> {


    UserVo getUser(Long id);

    PageVo getUserList(Integer pageNum, Integer pageSize, Long id);

    Boolean updateUser(UpdateUserDto updateUserDto);
}
