package com.jwt.tokenMongo.service;

import com.jwt.tokenMongo.model.User;
import com.jwt.tokenMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

  /*  @PostConstruct
        void init() {
        User user = User.builder()
                .username("user")
                .password(new BCryptPasswordEncoder().encode("pass"))
                .email("hm@ukr.net")
                .build();
        userRepository.save(user);
    }*/

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
