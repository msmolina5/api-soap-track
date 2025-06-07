package api_soap_track.services;

import api_soap_track.dto.GetTrackingStatusRequest;
import api_soap_track.dto.GetTrackingStatusResponse;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface TrackingService {
    @WebMethod
    GetTrackingStatusResponse getTrackingStatus(GetTrackingStatusRequest request);
}