package com.Test.gesfiliereniveau.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class FiliereRequest {
    @NotBlank(message = "Le libellé de la filière est obligatoire.")
    private String libelle;
} 