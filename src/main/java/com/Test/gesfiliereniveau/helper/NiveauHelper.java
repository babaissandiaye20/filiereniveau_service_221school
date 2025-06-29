package com.Test.gesfiliereniveau.helper;

import com.Test.gesfiliereniveau.dto.NiveauRequest;
import com.Test.gesfiliereniveau.dto.NiveauResponse;
import com.Test.gesfiliereniveau.exception.ApiException;
import com.Test.gesfiliereniveau.exception.NotFoundException;
import com.Test.gesfiliereniveau.mapper.NiveauMapper;
import com.Test.gesfiliereniveau.models.Niveau;
import com.Test.gesfiliereniveau.services.INiveau;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class NiveauHelper {
    private final INiveau iNiveau;
    private final NiveauMapper niveauMapper;

    public NiveauHelper(INiveau iNiveau, NiveauMapper niveauMapper) {
        this.iNiveau = iNiveau;
        this.niveauMapper = niveauMapper;
    }

    public NiveauResponse save(NiveauRequest niveauRequest) {
        if (iNiveau.findByLibelle(niveauRequest.getLibelle()) != null) {
            throw new ApiException("Un niveau avec le libellé [" + niveauRequest.getLibelle() + "] existe déjà!", 400);
        }
        Niveau niveau = iNiveau.save(niveauMapper.toNiveauEntity(niveauRequest));
        return niveauMapper.toNiveauResponse(niveau);
    }

    public List<NiveauResponse> findAll() {
        return iNiveau.findAll().stream().map(niveauMapper::toNiveauResponse).toList();
    }

    public NiveauResponse findById(Long id) {
        Niveau niveau = iNiveau.findById(id);
        if (niveau == null) {
            throw new NotFoundException("Niveau avec id " + id + " introuvable");
        }
        return niveauMapper.toNiveauResponse(niveau);
    }

    public boolean existsById(Long id) {
        return iNiveau.existsById(id);
    }

    // Méthodes update et delete à adapter selon besoin
} 