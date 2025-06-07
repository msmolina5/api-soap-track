package api_soap_track.dto;

import jakarta.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetTrackingStatusRequest {
    private String trackingNumber;
}
