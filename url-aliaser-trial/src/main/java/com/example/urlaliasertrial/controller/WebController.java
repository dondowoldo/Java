package com.example.urlaliasertrial.controller;

import com.example.urlaliasertrial.model.Alias;
import com.example.urlaliasertrial.model.Link;
import com.example.urlaliasertrial.service.AliasService;
import com.example.urlaliasertrial.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class WebController {

    private LinkService linkService;
    private AliasService aliasService;

    public WebController(LinkService linkService, AliasService aliasService) {
        this.linkService = linkService;
        this.aliasService = aliasService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("aliases", aliasService.findAll());
        return "index";
    }

    @PostMapping("/save-link")
    public String saveLink(RedirectAttributes ra, String url, String newAlias) {
        if (url == null || newAlias == null || url.isBlank() || newAlias.isBlank()) {
            ra.addFlashAttribute("error", "Both fields are mandatory!");
            return "redirect:/";
        }
        Optional<Link> optLink = linkService.findByUrl(url);
        Optional<Alias> optAlias = aliasService.findByAlias(newAlias);
        if (optAlias.isPresent()) {
            ra.addFlashAttribute("error", "Your alias is already in use!");
            ra.addFlashAttribute("url", url);
            ra.addFlashAttribute("newAlias", newAlias);
            return "redirect:/";
        }
        Link link = optLink.orElseGet(() -> new Link(url));
        Alias alias = new Alias(newAlias, link);
        link.getAliases().add(alias);
        linkService.save(link);
        ra.addFlashAttribute("createdAlias", alias);
        return "redirect:/";
    }

    @GetMapping("/a/{alias}")
    public String redirectView(@PathVariable String alias) {
        Optional<Alias> optionalAlias = aliasService.findByAlias(alias);
        if (optionalAlias.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            //return ResponseEntity.notFound().build();
        }
        Alias actualAlias = optionalAlias.get();
        actualAlias.increaseHitCount();
        aliasService.save(actualAlias);
        return "redirect:" + actualAlias.getLink().getUrl();
    }

}
