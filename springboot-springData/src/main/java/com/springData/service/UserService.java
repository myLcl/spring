package com.springData.service;

import com.springData.entity.User;

/**
 * Created by conglin.liu on 2017/6/1.
 */
public interface UserService {
    User findOne(Long id);
    void delete(Long id);
    void save(User user);
}
