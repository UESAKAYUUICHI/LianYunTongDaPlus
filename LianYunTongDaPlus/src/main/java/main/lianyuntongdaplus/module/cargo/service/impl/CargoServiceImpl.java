package main.lianyuntongdaplus.module.cargo.service.impl;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.module.cargo.dao.CargoRepository;
import main.lianyuntongdaplus.module.cargo.domain.Cargo;
import main.lianyuntongdaplus.module.cargo.form.SearchCargosForm;
import main.lianyuntongdaplus.module.cargo.service.CargoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author UESAKA
 * @Description null
 * @time 2025.7.29
 */
@Service
public class CargoServiceImpl implements CargoService {

    @Resource
    private CargoRepository cargoRepository;

    /**
     * 增加货物
     * */
    @Override
    public void addCargo(Cargo cargo) {
        if(cargoRepository.findById(cargo.getCargoId()).isEmpty()){
            cargoRepository.save(cargo);
        }else{
            throw new RuntimeException("货物已存在");
        }
    }

    /**
     * 删除货物
     * */
    @Override
    public void deleteCargoById(Integer id) {
        cargoRepository.deleteById(id);
    }



    /**
     * 根据id或名字查询货物
     * */
    @Override
    public List<Cargo> getCargoByNameOrId(SearchCargosForm form) {
        //获取表单中的值
        Integer id = form.getCargoId();
        String name = form.getCargoName();

        //新建返回列表
        List<Cargo> cargos = new ArrayList<>();

        //如果id和name都为空，查询所有订单
        if (id == null && name == null) {
            cargos = cargoRepository.findAll();
            return cargos;
        }

        //查找两个选项，添加到orders列表中
        if(id != null){
            cargos.addAll(cargoRepository.findByCargoId(id));
        }
        if(name != null){
            cargos.addAll(cargoRepository.findByCargoName(name));
        }

        //去重
        cargos = cargos.stream().distinct().collect(Collectors.toList());
        //返回结果
        return cargos;
    }

    /**
     * 初始化编辑模块
     * 打开编辑页面获取值
     **/
    @Override
    public Cargo iniEdit(Integer id) {
        Cargo cargo = cargoRepository.findById(id).orElse(null);
        return cargo;
    }

    /**
     * 修改后的表单提交处理
     */
    @Override
    public void editCargo(Cargo cargo) {
        try{
            cargoRepository.save(cargo);
        }catch (Exception e){
            e.printStackTrace();
        }
    }




}
