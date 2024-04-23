package com.grupo10.taller1.services.implementations;

import com.grupo10.taller1.models.dtos.LoginReqDTO;
import com.grupo10.taller1.models.dtos.RegisterDTO;
import com.grupo10.taller1.models.dtos.UserResDTO;
import com.grupo10.taller1.models.entities.UserE;
import com.grupo10.taller1.services.IUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImpl implements IUser {
    private static List<UserE> users = new ArrayList<>();
    static {
        users.add(new UserE(
                "user1234",
                "user1234@gmail.com",
                "Passw0rd!"));
        users.add(new UserE(
                "coolguy7",
                "coolguy7@gmail.com",
                "Summer21$"));
        users.add(new UserE(
                "powergirl",
                "powergirl@gmail.com",
                "Hero4ever!"));
    }

    public void newUser(RegisterDTO credentials) {
        UserE newUser = new UserE(
                credentials.getEmail(),
                credentials.getUsername(),
                credentials.getPassword());
        users.add(newUser);
    }

    public UserResDTO getUser(String userId) {
        UserResDTO aUser = new UserResDTO("username", "email");
        UserE user = users.stream()
                .filter(u -> {
                    if (u.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                        return u.getEmail().equals(userId);
                    } else {
                        return u.getUsername().equals(userId);
                    }
                })
                .findFirst().orElse(null);
        aUser.setEmail(user.getEmail());
        aUser.setUsername(user.getUsername());
        return aUser;
    }


    public UserResDTO loginUser(LoginReqDTO credentials) {
        UserResDTO log = new UserResDTO("username", "email");
        UserE user = users.stream()
                .filter(u -> {
                    if (u.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                        return u.getEmail().equals(credentials.getIdentifier());
                    } else {
                        return u.getUsername().equals(credentials.getIdentifier());
                    }
                })
                .findFirst().orElse(null);
        if (user != null && user.getPassword().equals(credentials.getPassword())) {
            log.setEmail(user.getEmail());
            log.setUsername(user.getUsername());
            return log;
        } else {
            return null;
        }

    }

}
