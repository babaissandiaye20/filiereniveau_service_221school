package com.Test.gesfiliereniveau.mapper;

import com.Test.gesfiliereniveau.dto.NiveauRequest;
import com.Test.gesfiliereniveau.dto.NiveauResponse;
import com.Test.gesfiliereniveau.models.Niveau;
import org.springframework.stereotype.Component;

@Component
public class NiveauMapper {
    public Niveau toNiveauEntity(NiveauRequest request) {
        return Niveau.builder()
                .libelle(request.getLibelle())
                .build();
    }

    public NiveauResponse toNiveauResponse(Niveau niveau) {
        NiveauResponse response = new NiveauResponse();
        response.setId(niveau.getId());
        response.setLibelle(niveau.getLibelle());
        return response;
    }
} 