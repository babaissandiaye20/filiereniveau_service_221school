package com.Test.gesfiliereniveau.mapper;

import com.Test.gesfiliereniveau.dto.FiliereRequest;
import com.Test.gesfiliereniveau.dto.FiliereResponse;
import com.Test.gesfiliereniveau.models.Filiere;
import org.springframework.stereotype.Component;

@Component
public class FiliereMapper {
    public Filiere toFiliereEntity(FiliereRequest request) {
        return Filiere.builder()
                .libelle(request.getLibelle())
                .build();
    }

    public FiliereResponse toFiliereResponse(Filiere filiere) {
        FiliereResponse response = new FiliereResponse();
        response.setId(filiere.getId());
        response.setLibelle(filiere.getLibelle());
        return response;
    }
} 