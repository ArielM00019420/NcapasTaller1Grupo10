package com.grupo10.taller1.models.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserE {
    private String username;
    private String email;
    private String password;
}
