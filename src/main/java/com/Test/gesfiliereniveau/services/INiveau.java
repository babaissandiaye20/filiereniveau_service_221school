package com.Test.gesfiliereniveau.services;

import com.Test.gesfiliereniveau.models.Niveau;
import java.util.List;

public interface INiveau {
    List<Niveau> findAll();
    Niveau save(Niveau niveau);
    Niveau findById(Long id);
    Niveau findByLibelle(String libelle);
    List<Niveau> findNiveauxWithoutThisLibelle(String libelle);
    void delete(Niveau niveau);
    void softDelete(Long id);
    Niveau update(Niveau niveau);
    boolean existsById(Long id);
    String getLibelleById(Long id);
} 