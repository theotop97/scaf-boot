package com.scaf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.scaf.domain.entity.User;
import com.scaf.mapper.UserMapper;
import com.scaf.service.UserService;
import com.scaf.service.business.dto.UpdateUserDto;
import com.scaf.service.business.vo.PageVo;
import com.scaf.service.business.vo.UserDetailVo;
import com.scaf.service.business.vo.UserVo;
import com.scaf.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public UserVo getUser(Long id) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, id);
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.nonNull(user)) {
            return UserVo.convert(user);
        }
        return null;
    }

    @Override
    public PageVo getUserList(Integer pageNum, Integer pageSize, Long id) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Objects.nonNull(id) && id > 0, User::getId, id);
        //分页查询

        Page<User> page = new Page<>(pageNum, pageSize);
        page(page, queryWrapper);
        List<UserVo> userVos = BeanCopyUtils.copyBeanList(page.getRecords(), UserVo.class);
        return new PageVo(userVos, page.getTotal());
    }

    @Override
    public Boolean updateUser(UpdateUserDto updateUserDto) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserId, updateUserDto.getUserId());
        User user = userMapper.selectOne(queryWrapper);
        if (!Objects.nonNull(user)) {
            return false;
        }
        user.setUserName(updateUserDto.getUserName());
        user.setMail(updateUserDto.getMail());
        user.setPhoneNumber(updateUserDto.getPhoneNumber());
        return userMapper.updateById(user) == 1;

    }

    @Override
    public UserDetailVo getUserDetail(Long id) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, id);
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.nonNull(user)) {
            return UserDetailVo.convert(user);
        }
        return new UserDetailVo();
    }
}
