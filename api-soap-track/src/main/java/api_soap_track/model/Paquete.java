package api_soap_track.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackingNumber;
    private String senderName;
    private String receiverName;
    private String origin;
    private String destination;
    private Double weight;
    private String dimensions;
    private String status;
    private String currentLocation;
    private LocalDate estimatedDeliveryDate;

    @OneToMany(mappedBy = "paquete", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TrackingEvent> history;
}
