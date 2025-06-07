package api_soap_track.dto;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetTrackingStatusResponse {
    private String status;
    private String currentLocation;
    private String estimatedDeliveryDate;
    private List<TrackingEventDTO> history;
}