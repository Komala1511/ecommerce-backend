package com.ecommerce.controller;

import com.ecommerce.dto.request.LoginRequestDTO;
import com.ecommerce.dto.response.AuthResponseDTO;
import com.ecommerce.entity.User;
import com.ecommerce.security.JwtUtil;
import com.ecommerce.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService,JwtUtil jwtUtil,PasswordEncoder passwordEncoder){
    this.userService=userService;
    this.jwtUtil=jwtUtil;
    this.passwordEncoder=passwordEncoder;
    }


    @PostMapping("/login")

    public ResponseEntity<?>login(@RequestBody LoginRequestDTO request){



    //1.find User by email
    var userOptional=userService.findByEmail(request.getEmail());
    if (userOptional.isEmpty())
    {return ResponseEntity
            .status(401)
            .body("Invalid Email or Password");
    }

    User user=userOptional.get();


    //2.Check Password
    if (!passwordEncoder.matches(request.getPassword(), user.getPassword()))
    {return ResponseEntity
            .status(401)
            .body("Invalid Email or Password");
    }


    //3.Generate Token
    String token=jwtUtil.generateToken(request.getEmail());

    //4.Return Token
    return ResponseEntity.ok(new AuthResponseDTO(token));
    }

}