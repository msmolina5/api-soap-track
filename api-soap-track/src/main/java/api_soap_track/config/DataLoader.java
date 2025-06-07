package api_soap_track.config;

import api_soap_track.model.*;
import api_soap_track.repository.PaqueteRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final PaqueteRepository paqueteRepository;

    @PostConstruct
    public void init() {
        if (paqueteRepository.existsById(1L)) return;

        Paquete paquete = new Paquete();
        paquete.setTrackingNumber("PE1234567890");
        paquete.setSenderName("Carlos Rojas");
        paquete.setReceiverName("Ana Pérez");
        paquete.setOrigin("Quito");
        paquete.setDestination("Lima-PE");
        paquete.setWeight(2.5);
        paquete.setDimensions("30x20x10");
        paquete.setStatus("En tránsito");
        paquete.setCurrentLocation("Lima - Perú");
        paquete.setEstimatedDeliveryDate(LocalDate.of(2025, 6, 10));

        TrackingEvent e1 = new TrackingEvent(null, "Paquete recibido", "Lima", LocalDateTime.of(2025, 6, 6, 10, 0), paquete);
        TrackingEvent e2 = new TrackingEvent(null, "Paquete en bodega", "Lima", LocalDateTime.of(2025, 6, 7, 14, 30), paquete);
        paquete.setEventos(Arrays.asList(e1, e2));

        paqueteRepository.save(paquete);
    }
}