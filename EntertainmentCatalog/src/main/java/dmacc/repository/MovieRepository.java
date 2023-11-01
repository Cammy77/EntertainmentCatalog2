package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dmacc.beans.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {}