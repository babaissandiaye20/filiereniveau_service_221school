package com.Test.gesfiliereniveau.services;

import com.Test.gesfiliereniveau.models.Filiere;
import java.util.List;

public interface IFiliere {
    List<Filiere> findAll();
    Filiere save(Filiere filiere);
    Filiere findById(Long id);
    Filiere findByLibelle(String libelle);
    List<Filiere> findFilieresWithoutThisLibelle(String libelle);
    void delete(Filiere filiere);
    void softDelete(Long id);
    Filiere update(Filiere filiere);
    boolean existsById(Long id);
} 
