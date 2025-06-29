package com.Test.gesfiliereniveau.controller;

import com.Test.gesfiliereniveau.dto.FiliereRequest;
import com.Test.gesfiliereniveau.dto.FiliereResponse;
import com.Test.gesfiliereniveau.helper.FiliereHelper;
import com.Test.gesfiliereniveau.response.RequestResponse;
import com.Test.gesfiliereniveau.response.ResponseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/filieres")
public class FiliereController {
    private final FiliereHelper filiereHelper;

    public FiliereController(FiliereHelper filiereHelper) {
        this.filiereHelper = filiereHelper;
    }

    @PostMapping
    public ResponseEntity<RequestResponse<FiliereResponse>> createFiliere(@Valid @RequestBody FiliereRequest request) {
        FiliereResponse response = filiereHelper.save(request);
        return ResponseEntity.status(201).body(
            RequestResponse.<FiliereResponse>builder()
                .code(201)
                .status("CREATED")
                .data(response)
                .message("Filière créée avec succès")
                .build()
        );
    }

    @GetMapping
    public ResponseEntity<ResponseResponse<List<FiliereResponse>>> getAllFilieres() {
        List<FiliereResponse> filieres = filiereHelper.findAll();
        return ResponseEntity.ok(
            ResponseResponse.<List<FiliereResponse>>builder()
                .code(200)
                .status("OK")
                .data(filieres)
                .message("Liste des filières")
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseResponse<FiliereResponse>> getFiliereById(@PathVariable Long id) {
        FiliereResponse response = filiereHelper.findById(id);
        return ResponseEntity.ok(
            ResponseResponse.<FiliereResponse>builder()
                .data(response)
                .message("Filière trouvée")
                .build()
        );
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return filiereHelper.existsById(id);
    }

    @GetMapping("/{id}/libelle")
    public String getLibelleById(@PathVariable Long id) {
        return filiereHelper.findById(id).getLibelle();
    }

    // Ajoute ici les endpoints pour update, delete, etc.
} 
