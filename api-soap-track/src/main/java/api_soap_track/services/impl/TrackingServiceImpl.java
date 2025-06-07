package api_soap_track.services.impl;

import api_soap_track.dto.*;
import api_soap_track.model.*;
import api_soap_track.repository.*;
import api_soap_track.services.TrackingService;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@WebService(endpointInterface = "api_soap_track.services.TrackingService")
public class TrackingServiceImpl implements TrackingService {

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Override
    public GetTrackingStatusResponse getTrackingStatus(GetTrackingStatusRequest request) {
        Optional<Paquete> optional = paqueteRepository.findByTrackingNumber(request.getTrackingNumber());

        if (optional.isEmpty()) {
            throw new RuntimeException("Tracking number not found");
        }

        Paquete paquete = optional.get();

        GetTrackingStatusResponse response = new GetTrackingStatusResponse();
        response.setStatus(paquete.getStatus());
        response.setCurrentLocation(paquete.getCurrentLocation());
        response.setEstimatedDeliveryDate(paquete.getEstimatedDeliveryDate().toString());

        List<TrackingEventDTO> history = paquete.getHistory().stream().map(event -> {
            TrackingEventDTO dto = new TrackingEventDTO();
            dto.setDescription(event.getDescription());
            dto.setLocation(event.getLocation());
            dto.setTimestamp(event.getTimestamp().toString());
            return dto;
        }).collect(Collectors.toList());

        response.setHistory(history);
        return response;
    }
}
