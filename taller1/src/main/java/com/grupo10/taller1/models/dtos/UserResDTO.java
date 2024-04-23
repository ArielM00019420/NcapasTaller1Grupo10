package com.grupo10.taller1.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResDTO {
    private String username;
    private String email;
}
