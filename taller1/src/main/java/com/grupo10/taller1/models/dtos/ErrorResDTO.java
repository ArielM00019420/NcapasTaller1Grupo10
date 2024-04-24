package com.grupo10.taller1.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResDTO {
        String code;
        String error;
}
