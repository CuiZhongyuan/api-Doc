package com.taltools.service;

import com.github.pagehelper.PageInfo;
import com.taltools.entity.UserEntity;
import com.taltools.entity.query.UserQuery;

import java.util.List;

public interface UserService {
    // 查询所有用户
    public List<UserEntity> listUser();

    // 根据用户名来查询用户  并分页展示
    public PageInfo<UserEntity> listUserByName(UserQuery userQuery);

    //根据id删除用户
    public boolean deleteUserById(Integer id);

    // 根据id查询用户
    public UserEntity queryUserById(Integer id);

    // 修改用户
    public boolean updateUser(UserEntity user);

    // 新增用户
    public boolean addUser(UserEntity user);

}
