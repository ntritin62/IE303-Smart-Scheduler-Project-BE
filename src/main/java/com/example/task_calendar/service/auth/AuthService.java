package com.example.task_calendar.service.auth;


import com.example.task_calendar.dto.SignUpDTO;
import com.example.task_calendar.dto.UserDTO;

public interface AuthService {
    UserDTO createUser(SignUpDTO signupDTO);
}
