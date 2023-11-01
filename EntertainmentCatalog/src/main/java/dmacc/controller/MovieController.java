package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import dmacc.beans.Movie;
import dmacc.repository.MovieRepository;

@Controller
public class MovieController {
    
    @Autowired
    private MovieRepository movieRepo;

    @GetMapping("/viewAllMovies")
    public String viewAllMovies(Model model) {
        model.addAttribute("movies", movieRepo.findAll());
        return "movieResults";
    }

    @GetMapping("/inputMovie")
    public String addNewMovie(Model model) {
        Movie m = new Movie();
        model.addAttribute("newMovie", m);
        return "inputMovie";
    }

    @PostMapping("/inputMovie")
    public String addNewMovie(@ModelAttribute Movie m, Model model) {
        movieRepo.save(m);
        return "redirect:/viewAllMovies";
    }

    @GetMapping("/editMovie/{id}")
    public String editMovie(@PathVariable("id") long id, Model model) {
        Movie m = movieRepo.findById(id).orElse(null);
        model.addAttribute("newMovie", m);
        return "inputMovie";
    }

    @PostMapping("/updateMovie/{id}")
    public String updateMovie(@PathVariable("id") long id, @ModelAttribute Movie m, Model model) {
        movieRepo.save(m);
        return "redirect:/viewAllMovies";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") long id, Model model) {
        Movie m = movieRepo.findById(id).orElse(null);
        if (m != null) {
            movieRepo.delete(m);
        }
        return "redirect:/viewAllMovies";
    }
}