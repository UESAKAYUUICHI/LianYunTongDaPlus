package main.lianyuntongdaplus.module.cargo.domain;


/**
 * @Author UESAKA
 * @Description null
 * @time 2025.7.29
 */
import jakarta.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cargo_id")  // 明确指定列名
    private int cargoId; //货物编号
    @Column(name = "cargo_name")
    private String cargoName; //货物名称
    @Column(name = "cargo_type")
    private String cargoType; //货物种类
    @Column(name = "cargo_weight")
    private Double cargoWeight; //货物重量
    @Column(name = "cargo_isdangreous")
    private String isDangerous; //是否危险

    @ManyToOne
    @JoinColumn(name = "transport_id")
    private main.lianyuntongdaplus.module.cargo.domain.Transport transport;
    public Cargo(){}

    public Cargo(int cargoId, String cargoName, String cargoType, Double cargoWeight, String isDangerous) {
        this.cargoId = cargoId;
        this.cargoName = cargoName;
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
        this.isDangerous = isDangerous;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargoId) {
        this.cargoId = cargoId;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public Double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    public String getIsDangerous() {
        return isDangerous;
    }

    public void setIsDangerous(String isDangerous) {
        this.isDangerous = isDangerous;
    }

    public main.lianyuntongdaplus.module.cargo.domain.Transport getTransport() {
        return transport;
    }

    public void setTransport(main.lianyuntongdaplus.module.cargo.domain.Transport transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "cargoId=" + cargoId +
                ", cargoName='" + cargoName + '\'' +
                ", cargoType='" + cargoType + '\'' +
                ", cargoWeight=" + cargoWeight +
                ", isDangerous='" + isDangerous + '\'' +
                '}';
    }
}