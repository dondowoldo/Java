package com.example.urlaliasertrial.repository;

import com.example.urlaliasertrial.model.Link;
import org.springframework.data.repository.ListCrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface LinkRepository extends ListCrudRepository<Link, Long> {
    Optional<Link> findByUrl(String url);
}
