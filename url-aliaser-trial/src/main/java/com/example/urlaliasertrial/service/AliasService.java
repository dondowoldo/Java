package com.example.urlaliasertrial.service;

import com.example.urlaliasertrial.model.Alias;
import com.example.urlaliasertrial.repository.AliasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AliasService {
    private AliasRepository aliases;

    public AliasService(AliasRepository aliases) {
        this.aliases = aliases;
    }

    public List<Alias> findAll() {
        return aliases.findAll();
    }

    public Optional<Alias> findByAlias(String alias) {
        return aliases.findByAlias(alias);
    }

    public Alias save(Alias alias) {
        return aliases.save(alias);
    }


    public Optional<Alias> findById(Long id) {
        return aliases.findById(id);
    }

    public void removeById(Long id) {
        aliases.deleteById(id);
    }
}
