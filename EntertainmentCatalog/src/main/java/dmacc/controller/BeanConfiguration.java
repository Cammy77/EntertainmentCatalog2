package dmacc.controller;

import dmacc.beans.Movie;
import dmacc.beans.StreamingService;
import dmacc.beans.Actor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class BeanConfiguration {

    @Bean
    public Movie movie() {
        Movie movie = new Movie();
        movie.setName("Example Movie");
        movie.setGenre("Science Fiction");
        movie.setReleaseDate(LocalDate.of(2023, 1, 1));
        movie.setMainActor(mainActor());
        movie.setStreamingService(streamingService());
        return movie;
    }

    @Bean
    public StreamingService streamingService() {
        StreamingService service = new StreamingService();
        service.setName("Example Streaming Service");
        return service;
    }

    @Bean
    public Actor mainActor() {
        Actor actor = new Actor();
        actor.setName("Example Actor");
        actor.setAge(35);
        return actor;
    }
}