package com.Test.gesfiliereniveau.repository;

import com.Test.gesfiliereniveau.models.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Long> {
    @Query("SELECT f FROM Filiere f WHERE f.libelle = :libelle")
    Filiere findByLibelle(String libelle);

    @Query("SELECT f FROM Filiere f WHERE f.libelle != :libelle")
    List<Filiere> findFilieresWithoutThisLibelle(String libelle);

    @Query("SELECT f FROM Filiere f WHERE f.deleted = false")
    List<Filiere> findAllNotDeleted();

    boolean existsById(Long id);

    // Retourne le libellé de la filière par id
    @Query("SELECT f.libelle FROM Filiere f WHERE f.id = :id")
    String getLibelleById(Long id);
} 