package com.Test.gesfiliereniveau.helper;

import com.Test.gesfiliereniveau.dto.FiliereRequest;
import com.Test.gesfiliereniveau.dto.FiliereResponse;
import com.Test.gesfiliereniveau.exception.ApiException;
import com.Test.gesfiliereniveau.exception.NotFoundException;
import com.Test.gesfiliereniveau.mapper.FiliereMapper;
import com.Test.gesfiliereniveau.models.Filiere;
import com.Test.gesfiliereniveau.services.IFiliere;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class FiliereHelper {
    private final IFiliere iFiliere;
    private final FiliereMapper filiereMapper;

    public FiliereHelper(IFiliere iFiliere, FiliereMapper filiereMapper) {
        this.iFiliere = iFiliere;
        this.filiereMapper = filiereMapper;
    }

    public FiliereResponse save(FiliereRequest filiereRequest) {
        if (iFiliere.findByLibelle(filiereRequest.getLibelle()) != null) {
            throw new ApiException("Une filière avec le libellé [" + filiereRequest.getLibelle() + "] existe déjà!", 400);
        }
        Filiere filiere = iFiliere.save(filiereMapper.toFiliereEntity(filiereRequest));
        return filiereMapper.toFiliereResponse(filiere);
    }

    public List<FiliereResponse> findAll() {
        return iFiliere.findAll().stream().map(filiereMapper::toFiliereResponse).toList();
    }

    public FiliereResponse findById(Long id) {
        Filiere filiere = iFiliere.findById(id);
        if (filiere == null) {
            throw new NotFoundException("Filière avec id " + id + " introuvable");
        }
        return filiereMapper.toFiliereResponse(filiere);
    }

    public boolean existsById(Long id) {
        return iFiliere.existsById(id);
    }

    public String getLibelleById(Long id) {
        return iFiliere.getLibelleById(id);
    }

    // Méthodes update et delete à adapter selon besoin
} 