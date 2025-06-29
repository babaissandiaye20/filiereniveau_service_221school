package com.Test.gesfiliereniveau.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class NiveauRequest {
    @NotBlank(message = "Le libellé du niveau est obligatoire.")
    private String libelle;
} 