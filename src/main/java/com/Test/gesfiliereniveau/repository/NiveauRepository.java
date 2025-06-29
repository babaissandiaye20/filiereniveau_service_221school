package com.Test.gesfiliereniveau.repository;

import com.Test.gesfiliereniveau.models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {
    @Query("SELECT n FROM Niveau n WHERE n.libelle = :libelle")
    Niveau findByLibelle(String libelle);

    @Query("SELECT n FROM Niveau n WHERE n.libelle != :libelle")
    List<Niveau> findNiveauxWithoutThisLibelle(String libelle);

    @Query("SELECT n FROM Niveau n WHERE n.deleted = false")
    List<Niveau> findAllNotDeleted();

    boolean existsById(Long id);
} 