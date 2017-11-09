package com.springData.service;

import com.springData.entity.User;
import com.springData.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by conglin.liu on 2017/6/1.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Cacheable(value = "user")
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    @CacheEvict(value="user")
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
//    @CachePut(value="user",key = "#user.id")
    public void save(User user) {
        userRepository.save(user);
    }
}
