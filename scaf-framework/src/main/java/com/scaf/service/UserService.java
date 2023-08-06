package com.scaf.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.scaf.domain.entity.User;
import com.scaf.service.business.dto.UpdateUserDto;
import com.scaf.service.business.vo.PageVo;
import com.scaf.service.business.vo.UserDetailVo;
import com.scaf.service.business.vo.UserVo;

public interface UserService extends IService<User> {


    UserVo getUser(Long id);

    PageVo getUserList(Integer pageNum, Integer pageSize, Long id);

    Boolean updateUser(UpdateUserDto updateUserDto);

    UserDetailVo getUserDetail(Long id);
}
