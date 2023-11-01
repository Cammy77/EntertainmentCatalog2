package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Actor;
import dmacc.repository.ActorRepository;

@Controller
public class ActorController {
    
    @Autowired
    private ActorRepository actorRepo;

    @GetMapping("/viewAllActors")
    public String viewAllActors(Model model) {
        model.addAttribute("actors", actorRepo.findAll());
        return "actorResults";
    }

    @GetMapping("/inputActor")
    public String addNewActor(Model model) {
        Actor a = new Actor();
        model.addAttribute("newActor", a);
        return "inputActor";
    }

    @PostMapping("/inputActor")
    public String addNewActor(@ModelAttribute Actor a, Model model) {
        actorRepo.save(a);
        return "redirect:/viewAllActors";
    }

    @GetMapping("/editActor/{id}")
    public String editActor(@PathVariable("id") long id, Model model) {
        Actor a = actorRepo.findById(id).orElse(null);
        model.addAttribute("newActor", a);
        return "inputActor";
    }

    @PostMapping("/updateActor/{id}")
    public String updateActor(@PathVariable("id") long id, @ModelAttribute Actor a, Model model) {
        actorRepo.save(a);
        return "redirect:/viewAllActors";
    }

    @GetMapping("/deleteActor/{id}")
    public String deleteActor(@PathVariable("id") long id, Model model) {
        Actor a = actorRepo.findById(id).orElse(null);
        if (a != null) {
            actorRepo.delete(a);
        }
        return "redirect:/viewAllActors";
    }
}