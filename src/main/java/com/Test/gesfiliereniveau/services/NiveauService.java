package com.Test.gesfiliereniveau.services;

import com.Test.gesfiliereniveau.models.Niveau;
import com.Test.gesfiliereniveau.repository.NiveauRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NiveauService implements INiveau {
    private final NiveauRepository niveauRepository;

    public NiveauService(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }

    @Override
    public List<Niveau> findAll() {
        return niveauRepository.findAll();
    }

    @Override
    public Niveau save(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public Niveau findById(Long id) {
        return niveauRepository.findById(id).orElse(null);
    }

    @Override
    public Niveau findByLibelle(String libelle) {
        return niveauRepository.findByLibelle(libelle);
    }

    @Override
    public List<Niveau> findNiveauxWithoutThisLibelle(String libelle) {
        return niveauRepository.findNiveauxWithoutThisLibelle(libelle);
    }

    @Override
    public void delete(Niveau niveau) {
        niveauRepository.delete(niveau);
    }

    @Override
    public void softDelete(Long id) {
        Niveau niveau = niveauRepository.findById(id).orElse(null);
        if (niveau != null) {
            niveau.setDeleted(true);
            niveauRepository.save(niveau);
        }
    }

    @Override
    public Niveau update(Niveau niveau) {
        return niveauRepository.save(niveau);
    }

    @Override
    public boolean existsById(Long id) {
        return niveauRepository.existsById(id);
    }
} 