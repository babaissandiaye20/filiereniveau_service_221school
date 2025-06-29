package com.Test.gesfiliereniveau.services;

import com.Test.gesfiliereniveau.models.Filiere;
import com.Test.gesfiliereniveau.repository.FiliereRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FiliereService implements IFiliere {
    private final FiliereRepository filiereRepository;

    public FiliereService(FiliereRepository filiereRepository) {
        this.filiereRepository = filiereRepository;
    }

    @Override
    public List<Filiere> findAll() {
        return filiereRepository.findAll();
    }

    @Override
    public Filiere save(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public Filiere findById(Long id) {
        return filiereRepository.findById(id).orElse(null);
    }

    @Override
    public Filiere findByLibelle(String libelle) {
        return filiereRepository.findByLibelle(libelle);
    }

    @Override
    public List<Filiere> findFilieresWithoutThisLibelle(String libelle) {
        return filiereRepository.findFilieresWithoutThisLibelle(libelle);
    }

    @Override
    public void delete(Filiere filiere) {
        filiereRepository.delete(filiere);
    }

    @Override
    public void softDelete(Long id) {
        Filiere filiere = filiereRepository.findById(id).orElse(null);
        if (filiere != null) {
            filiere.setDeleted(true);
            filiereRepository.save(filiere);
        }
    }

    @Override
    public Filiere update(Filiere filiere) {
        return filiereRepository.save(filiere);
    }

    @Override
    public boolean existsById(Long id) {
        return filiereRepository.existsById(id);
    }
} 