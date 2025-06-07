package api_soap_track.config;

import api_soap_track.services.TrackingService;
import jakarta.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    private final Bus bus;
    private final TrackingService trackingService;

    public CxfConfig(Bus bus, TrackingService trackingService) {
        this.bus = bus;
        this.trackingService = trackingService;
    }

    @Bean
    public Endpoint trackingEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, trackingService);
        endpoint.publish("/ws/TrackingService");
        return endpoint;
    }
}
