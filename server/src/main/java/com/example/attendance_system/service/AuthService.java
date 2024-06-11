package com.example.attendance_system.service;

import com.example.attendance_system.model.User;
import com.example.attendance_system.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private Map<String, String> users = new HashMap<>();

    public AuthService() {
        users.put("user", "password");
    }
	@Autowired
    private JwtUtil jwtUtil;

    public String login(User user) {
        // Dummy logic: you should implement proper validation
        if ("user".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return jwtUtil.generateToken(user.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }
    public boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
	
}
