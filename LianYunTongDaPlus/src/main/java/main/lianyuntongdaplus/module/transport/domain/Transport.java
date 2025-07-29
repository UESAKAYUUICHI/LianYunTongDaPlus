package main.lianyuntongdaplus.module.cargo.domain;


/**
 * @Author UESAKA
 * @Description null
 * @time 2025.7.29
 */
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transport_id")
    private Integer transportId;

    @Column(nullable = false,name = "start_location")
    private String startLocation;

    @Column(nullable = false,name = "current_location")
    private String currentLocation;

    @Column(updatable = false,name = "create_time")
    private LocalDateTime createTime = LocalDateTime.now();

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @OneToMany(mappedBy = "transport")
    private List<Cargo> cargos = new ArrayList<>();

    public Transport() {
    }

    public Transport(Integer transportId, String startLocation, String currentLocation, LocalDateTime createTime, LocalDateTime arrivalTime) {
        this.transportId = transportId;
        this.startLocation = startLocation;
        this.currentLocation = currentLocation;
        this.createTime = createTime;
        this.arrivalTime = arrivalTime;
    }

    public Integer getTransportId() {
        return transportId;
    }

    public void setTransportId(Integer transportId) {
        this.transportId = transportId;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<Cargo> getCargos() { return cargos; }
    public void setCargos(List<Cargo> cargos) { this.cargos = cargos; }
}