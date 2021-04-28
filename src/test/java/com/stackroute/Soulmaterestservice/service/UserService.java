package com.stackroute.Soulmaterestservice.service;

import com.stackroute.Soulmaterestservice.repository.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
class UserService {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
}