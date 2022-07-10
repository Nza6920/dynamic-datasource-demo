package com.niu.datasource.service;

import com.niu.datasource.config.DbSelector;
import com.niu.datasource.dao.UserRepository;
import com.niu.datasource.entity.User;
import com.niu.datasource.enums.DynamicDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        user.setUserId(UUID.randomUUID().toString());
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);
        return user;
    }

    @DbSelector(value = DynamicDataSource.SLAVE)
    @Transactional(readOnly = true)
    public User find(String userId) {
        return userRepository.findById(userId).orElseThrow(NotFoundException::new);
    }
}
