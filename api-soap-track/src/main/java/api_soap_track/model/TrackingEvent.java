package api_soap_track.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackingEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String location;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "paquete_id")
    private Paquete paquete;
}
