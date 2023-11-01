package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dmacc.beans.StreamingService;

public interface StreamingServiceRepository extends JpaRepository<StreamingService, String> {}