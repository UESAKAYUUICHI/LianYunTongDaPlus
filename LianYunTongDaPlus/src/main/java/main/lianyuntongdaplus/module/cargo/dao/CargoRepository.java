package main.lianyuntongdaplus.module.cargo.dao;

import main.lianyuntongdaplus.module.cargo.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {

    // 根据名称模糊查询
    List<Cargo> findByCargoNameContaining(String cargoName);

    // 根据类型查询
    List<Cargo> findByCargoType(String cargoType);

    // 根据危险品类型查询
    List<Cargo> findByIsDangerous(String isDangerous);

    // 根据运输ID查找货物
    List<Cargo> findByTransportTransportId(Integer transportId);

    Collection<? extends Cargo> findByCargoId(Integer id);

    Collection<? extends Cargo> findByCargoName(String name);
}