package com.grupo10.taller1.controllers;

import com.grupo10.taller1.models.dtos.ErrorResDTO;
import com.grupo10.taller1.models.dtos.LoginReqDTO;
import com.grupo10.taller1.models.dtos.RegisterDTO;
import com.grupo10.taller1.models.dtos.UserResDTO;
import com.grupo10.taller1.services.IUser;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        UserResDTO login = null;

        if (validations.hasErrors() || logInfo == null){
            ErrorResDTO error = new ErrorResDTO("400", "Identificador o contrasena invalidos");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        login = userServices.loginUser(logInfo);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @GetMapping("/user/{nameEmail}")
    public ResponseEntity<?> getUser(@PathVariable String nameEmail){
        if(userServices.getUser(nameEmail) != null){
            return new ResponseEntity<>(userServices.getUser(nameEmail), HttpStatus.OK);
        } else {
            ErrorResDTO error = new ErrorResDTO("404", "Usuario no encontrado");
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user/")
    public ResponseEntity<?> createUser(@RequestBody @Valid RegisterDTO newUser, BindingResult validations){
        if (validations.hasErrors() || newUser == null){
            ErrorResDTO error = new ErrorResDTO("400", "Usuario invalido");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        userServices.newUser(newUser);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}
