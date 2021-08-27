package com.taltools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taltools.dao.UserDao;
import com.taltools.entity.UserEntity;
import com.taltools.entity.query.UserQuery;
import com.taltools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserEntity> listUser() {
        return userDao.listUser();
    }

    @Override
    public PageInfo<UserEntity> listUserByName(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(),userQuery.getPageSize());
        return new PageInfo<UserEntity>(userDao.listUserByName(userQuery));
    }

    @Override
    public boolean deleteUserById(Integer id) {
        int i = userDao.deleteUserById(id);
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public UserEntity queryUserById(Integer id) {
        return userDao.queryUserById(id);
    }

    @Override
    public boolean updateUser(UserEntity user) {
        int i = userDao.updateUser(user);
        if(i > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean addUser(UserEntity user) {
        return userDao.addUser(user) > 0 ? true : false ;
    }
}
