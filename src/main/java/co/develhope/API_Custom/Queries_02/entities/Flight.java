package co.develhope.API_Custom.Queries_02.entities;

import javax.persistence.*;

@Entity
@Table(name = "Flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idFlight;
    private String description;
    private String fromAirport;
    private String toAirport;
    private Status status;

    public Flight() {
    }

    public Flight(String description, String fromAirport, String toAirport, Status status) {
        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = status;
    }
    public Integer getIdFlight() {
        return idFlight;
    }
    public void setIdFlight(Integer idFlight) {
        this.idFlight = idFlight;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getFromAirport() {
        return fromAirport;
    }
    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }
    public String getToAirport() {
        return toAirport;
    }
    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
