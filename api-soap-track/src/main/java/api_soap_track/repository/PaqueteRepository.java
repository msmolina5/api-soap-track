package api_soap_track.repository;

import api_soap_track.model.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
    Optional<Paquete> findByTrackingNumber(String trackingNumber);
    boolean existsByTrackingNumber(String trackingNumber);
}
