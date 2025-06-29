package com.Test.gesfiliereniveau.controller;

import com.Test.gesfiliereniveau.dto.NiveauRequest;
import com.Test.gesfiliereniveau.dto.NiveauResponse;
import com.Test.gesfiliereniveau.helper.NiveauHelper;
import com.Test.gesfiliereniveau.response.RequestResponse;
import com.Test.gesfiliereniveau.response.ResponseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/niveaux")
public class NiveauController {
    private final NiveauHelper niveauHelper;

    public NiveauController(NiveauHelper niveauHelper) {
        this.niveauHelper = niveauHelper;
    }

    @PostMapping
    public ResponseEntity<RequestResponse<NiveauResponse>> createNiveau(@Valid @RequestBody NiveauRequest request) {
        NiveauResponse response = niveauHelper.save(request);
        return ResponseEntity.status(201).body(
            RequestResponse.<NiveauResponse>builder()
                .code(201)
                .status("CREATED")
                .data(response)
                .message("Niveau créé avec succès")
                .build()
        );
    }

    @GetMapping
    public ResponseEntity<ResponseResponse<List<NiveauResponse>>> getAllNiveaux() {
        List<NiveauResponse> niveaux = niveauHelper.findAll();
        return ResponseEntity.ok(
            ResponseResponse.<List<NiveauResponse>>builder()
                .code(200)
                .status("OK")
                .data(niveaux)
                .message("Liste des niveaux")
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseResponse<NiveauResponse>> getNiveauById(@PathVariable Long id) {
        NiveauResponse response = niveauHelper.findById(id);
        return ResponseEntity.ok(
            ResponseResponse.<NiveauResponse>builder()
                .data(response)
                .message("Niveau trouvé")
                .build()
        );
    }

    @GetMapping("/{id}/exists")
    public boolean existsById(@PathVariable Long id) {
        return niveauHelper.existsById(id);
    }

    // Ajoute ici les endpoints pour update, delete, etc.
} 
