package com.example.security.Controller;

import com.example.security.Api.ApiResponse;
import com.example.security.Model.User;
import com.example.security.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity Register(@RequestBody @Valid User user) {
        authService.register(user);
        return ResponseEntity.status(200).body("Register");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        authService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }
    @PutMapping("/update/{username}")
    public ResponseEntity update(@PathVariable String username, @RequestBody @Valid User user){
        authService.Update(username, user);
        return ResponseEntity.status(200).body(new ApiResponse("Update"));

    }

}