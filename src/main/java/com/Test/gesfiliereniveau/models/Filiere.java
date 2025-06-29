package com.Test.gesfiliereniveau.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Filiere extends BaseModel {
    @Column(length = 100, unique = true)
    private String libelle;
} 