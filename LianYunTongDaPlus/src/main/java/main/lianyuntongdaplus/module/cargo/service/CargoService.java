package main.lianyuntongdaplus.module.cargo.service;

import main.lianyuntongdaplus.module.cargo.domain.Cargo;
import main.lianyuntongdaplus.module.cargo.form.SearchCargosForm;

import java.util.List;

public interface CargoService {
    /**
     * 增加货物
     * */
    void addCargo(Cargo cargo);

    /**
     * 删除货物
     * */
    void deleteCargoById(Integer id);

    /**
     * 根据货物名称或id查询货物
     * */
    List<Cargo> getCargoByNameOrId(SearchCargosForm form);

    /**
     * 初始化修改
     * */
    Cargo iniEdit(Integer id);

    /**
     * 修改货物
     * */
    void editCargo(Cargo cargo);

}
