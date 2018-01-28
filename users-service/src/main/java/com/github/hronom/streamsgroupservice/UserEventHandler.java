package com.github.hronom.streamsgroupservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @HandleBeforeCreate
    public void handleUserCreate(User user) {
        user.password = passwordEncoder.encode(user.password);
    }

    @HandleBeforeSave
    public void handleUserUpdate(User user) {
        if (StringUtils.hasText(user.password)) {
            User storedUser = userRepository.findOne(user.id);
            user.password = storedUser.password;
        } else {
            user.password = passwordEncoder.encode(user.password);
        }
    }
}
