package com.grupo10.taller1.services;

import com.grupo10.taller1.models.dtos.LoginReqDTO;
import com.grupo10.taller1.models.dtos.RegisterDTO;
import com.grupo10.taller1.models.dtos.UserResDTO;
import com.grupo10.taller1.models.entities.UserE;

public interface IUser {
    void newUser(RegisterDTO credentials);

    UserResDTO loginUser(LoginReqDTO credentials);

    UserResDTO getUser(String UserId);

}
