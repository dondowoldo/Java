package com.example.urlaliasertrial.controller;

import com.example.urlaliasertrial.dto.AliasDTO;
import com.example.urlaliasertrial.dto.AliasDeleteDTO;
import com.example.urlaliasertrial.model.Alias;
import com.example.urlaliasertrial.service.AliasService;
import com.example.urlaliasertrial.service.LinkService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ApiController {
    private AliasService aliasService;
    private LinkService linkService;

    public ApiController(AliasService aliasService, LinkService linkService) {
        this.aliasService = aliasService;
        this.linkService = linkService;
    }

    @GetMapping("/aliases")
    public ResponseEntity<List<AliasDTO>> getAliases() {
        return ResponseEntity.ok(
                aliasService.findAll().stream()
                        .map(AliasDTO::new)
                        .collect(Collectors.toList()));
    }

    @DeleteMapping("aliases/{id}")
    public ResponseEntity<?> deleteAlias(@PathVariable Long id, @RequestBody AliasDeleteDTO dto) {
        Optional<Alias> optAlias = aliasService.findById(id);
        if (optAlias.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        Alias alias = optAlias.get();
        if (!dto.secretCode().equals(alias.getSecretCode())) {
            return ResponseEntity.status(403).build();
        }
        aliasService.removeById(alias.getId());
        return ResponseEntity.status(204).build();
    }
}
