package dmacc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

/**  
* Taylor Layton - tglayton
* CIS171 22149
* Nov 1, 2023
* Windows 10 
*/
@Controller
public class WebController {

    // Autowire services
    // ...

    @GetMapping("/searchMovieByName")
    public String searchMovieByName(@RequestParam("movieName") String movieName, Model model) {
        // Implement search logic and add results to the model
        // List<Movie> searchResults = movieService.searchByName(movieName);
        // model.addAttribute("movies", searchResults);
        return "movieResults";
    }

    @GetMapping("/searchActorByName")
    public String searchActorByName(@RequestParam("actorName") String actorName, Model model) {
        // Implement search logic and add results to the model
        // List<Actor> searchResults = actorService.searchByName(actorName);
        // model.addAttribute("actors", searchResults);
        return "actorResults";
    }
}