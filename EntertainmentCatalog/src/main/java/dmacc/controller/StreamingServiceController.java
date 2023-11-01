package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import dmacc.beans.StreamingService;
import dmacc.repository.StreamingServiceRepository;

@Controller
public class StreamingServiceController {
    
    @Autowired
    private StreamingServiceRepository serviceRepo;

    @GetMapping("/viewAllServices")
    public String viewAllServices(Model model) {
        model.addAttribute("services", serviceRepo.findAll());
        return "serviceResults";
    }

    @GetMapping("/inputService")
    public String addNewService(Model model) {
        StreamingService s = new StreamingService();
        model.addAttribute("newService", s);
        return "inputService";
    }

    @PostMapping("/inputService")
    public String addNewService(@ModelAttribute StreamingService s, Model model) {
        serviceRepo.save(s);
        return "redirect:/viewAllServices";
    }

    @GetMapping("/deleteService/{name}")
    public String deleteService(@PathVariable("name") String name, Model model) {
        StreamingService s = serviceRepo.findById(name).orElse(null);
        if (s != null) {
            serviceRepo.delete(s);
        }
        return "redirect:/viewAllServices";
    }
}