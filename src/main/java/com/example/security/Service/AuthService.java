package com.example.security.Service;

import com.example.security.Api.ApiException;
import com.example.security.Model.User;
import com.example.security.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public void register(User user){
        user.setRole("CUSTOMER");
        String hashPassword= new BCryptPasswordEncoder().encode(user.getPassword());

        user.setPassword(hashPassword);
        authRepository.save(user);
    }
    public  void delete(Integer id){
        User user=authRepository.findUserById(id);
        if (user==null){
            throw new ApiException("Not");
        }
        authRepository.delete(user);

    }
    public void Update (String username,User user){
        User user1=authRepository.findUserByUsername(username);
        if (user1==null){
            throw new ApiException("Not");
        }
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());

        authRepository.save(user1);
    }
}