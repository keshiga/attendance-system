package com.example.attendance_system.service;

import com.example.attendance_system.model.User;
import com.example.attendance_system.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	@Autowired
    private JwtUtil jwtUtil;

    public String login(User user) {
        // Dummy logic: you should implement proper validation
        if ("user".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }
	
}
