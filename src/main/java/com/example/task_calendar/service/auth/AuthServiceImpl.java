package com.example.task_calendar.service.auth;


import com.example.task_calendar.dto.SignUpDTO;
import com.example.task_calendar.dto.UserDTO;
import com.example.task_calendar.entity.User;
import com.example.task_calendar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO createUser(SignUpDTO signupDTO) {
        if(userRepository.findFirstByEmail(signupDTO.getEmail()) != null) {
            return null;
        }
        User user = new User();
        user.setUserName(signupDTO.getUserName());
        user.setEmail(signupDTO.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
        User createdUser = userRepository.save(user);
        UserDTO userDTO = new UserDTO();
        userDTO.setId(createdUser.getId());
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setUserName(createdUser.getUserName());
        return userDTO;
    }
}
