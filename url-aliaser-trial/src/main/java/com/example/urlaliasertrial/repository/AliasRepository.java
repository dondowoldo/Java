package com.example.urlaliasertrial.repository;

import com.example.urlaliasertrial.model.Alias;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface AliasRepository extends ListCrudRepository<Alias, Long> {

    Optional<Alias> findByAlias(String alias);
}
