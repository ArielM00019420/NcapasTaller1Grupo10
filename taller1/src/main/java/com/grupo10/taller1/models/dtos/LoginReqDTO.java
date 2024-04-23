package com.grupo10.taller1.models.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginReqDTO {
    @NotEmpty(message = "Identifier required")
    private String identifier;
    @NotEmpty(message = "Password required")
    private String password;
}
