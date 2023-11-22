package com.greenfoxacademy.orientpracticemessingaround.controller;

import com.greenfoxacademy.orientpracticemessingaround.model.Human;
import com.greenfoxacademy.orientpracticemessingaround.model.Pet;
import com.greenfoxacademy.orientpracticemessingaround.service.HumanService;
import com.greenfoxacademy.orientpracticemessingaround.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class WebController {
    private HumanService humanService;
    private PetService petService;

    public WebController(HumanService humanService, PetService petService) {
        this.humanService = humanService;
        this.petService = petService;
    }

    @GetMapping("/")
    public String index(Model model, @ModelAttribute String error) {
        model.addAttribute("people", humanService.findAll());
        model.addAttribute("pets", petService.findAllWithoutOwner());
        return "index";
    }

    @PutMapping("/")
    public String assignPet(RedirectAttributes ra, Long petId, Long ownerId) {
        if (petId == null || ownerId == null) {
            ra.addFlashAttribute("error", "Invalid selections");
            return "redirect:/";
        }
        Optional<Human> optHuman = humanService.findById(ownerId);
        Optional<Pet> optPet = petService.findById(petId);
        if (optHuman.isEmpty() || optPet.isEmpty()) {
            ra.addFlashAttribute("error", "Invalid selections");
            return "redirect:/";
        }
        Human human = optHuman.get();
        Pet pet = optPet.get();
        human.getPets().add(pet);
        pet.setOwner(human);
        humanService.save(human);
        petService.save(pet);
        return "redirect:/";
    }

}
