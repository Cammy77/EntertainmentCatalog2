package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import dmacc.beans.Actor;
import dmacc.repository.ActorRepository;

@Controller
public class ActorController {
    
    @Autowired
    private ActorRepository actorRepo;

    @GetMapping({"/viewAllActors"})
    public String viewAllActors(Model model) {
        return populateActorsView(model);
    }
    
    @GetMapping("/actorInput")
    public String addNewActor(Model model) {
        Actor a = new Actor();
        model.addAttribute("newActor", a);
        return "actorInput";
    }

    @PostMapping("/actorInput")
    public String addNewActor(@ModelAttribute Actor a, Model model) {
        actorRepo.save(a);
        return populateActorsView(model);
    }

    @GetMapping("/editActor/{id}")
    public String showUpdateActor(@PathVariable("id") long id, Model model) {
        Actor a = actorRepo.findById(id).orElse(null);
        model.addAttribute("newActor", a);
        return "actorInput";
    }

    @PostMapping("/updateActor/{id}")
    public String reviseActor(@ModelAttribute Actor a, Model model) {
        actorRepo.save(a);
        return populateActorsView(model);
    }

    @GetMapping("/deleteActor/{id}")
    public String deleteActor(@PathVariable("id") long id, Model model) {
        Actor a = actorRepo.findById(id).orElse(null);
        if (a != null) {
            actorRepo.delete(a);
        }
        return populateActorsView(model);
    }

    private String populateActorsView(Model model) {
        if(actorRepo.findAll().isEmpty()) {
            return addNewActor(model);
        }
        model.addAttribute("actors", actorRepo.findAll());
        return "actorResults";
    }
}