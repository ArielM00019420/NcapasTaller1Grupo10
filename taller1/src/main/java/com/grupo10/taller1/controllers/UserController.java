package com.grupo10.taller1.controllers;

import com.grupo10.taller1.models.dtos.LoginReqDTO;
import com.grupo10.taller1.services.IUser;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/")
public class UserController {

    @Autowired
    private IUser userServices;

    @PostMapping("/auth/signin")
    public ResponseEntity<?> loginUser(@RequestBody @Valid LoginReqDTO logInfo, BindingResult validations){


        if (validations.hasErrors()) {

        }
        return null;
    }

    @GetMapping("/user/{nameEmail}")
    public ResponseEntity<?> getUser(){
        return null;
    }

    @PostMapping("/user/")
    public ResponseEntity<?> createUser(){
        return null;
    }
}
