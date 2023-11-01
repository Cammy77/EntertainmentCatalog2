package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dmacc.beans.Actor;

public interface ActorRepository extends JpaRepository<Actor, Long> {}