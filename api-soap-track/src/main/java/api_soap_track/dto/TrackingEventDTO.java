package api_soap_track.dto;

import jakarta.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TrackingEventDTO {
    private String description;
    private String location;
    private String timestamp;
}