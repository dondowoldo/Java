package com.example.urlaliasertrial.service;

import com.example.urlaliasertrial.model.Link;
import com.example.urlaliasertrial.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService {
    private LinkRepository links;

    public LinkService(LinkRepository links) {
        this.links = links;
    }

    public Optional<Link> findByUrl(String url) {
        return links.findByUrl(url);
    }

    public Link save(Link link) {
        return links.save(link);
    }
}
