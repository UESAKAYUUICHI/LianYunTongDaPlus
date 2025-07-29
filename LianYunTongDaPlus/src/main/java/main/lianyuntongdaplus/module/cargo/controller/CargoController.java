package main.lianyuntongdaplus.module.cargo.controller;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.commen.utils.result.MyResult;
import main.lianyuntongdaplus.module.cargo.domain.Cargo;
import main.lianyuntongdaplus.module.cargo.form.GetCargoDataForm;
import main.lianyuntongdaplus.module.cargo.form.SearchCargosForm;
import main.lianyuntongdaplus.module.cargo.service.CargoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author UESAKA
 * @Description null
 * @time 2025.7.29
 */
@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Resource
    private CargoService cargoService;

    /**
     * 增加货物
     * */
   @PostMapping("/addCargo")
    public MyResult addCargo(@RequestBody Cargo cargo){
       try{
           cargoService.addCargo(cargo);
           return MyResult.result(cargo, MyResult.SUCCESS_MESSAGE, MyResult.SUCCESS_CODE);
       }catch (Exception e){
           return MyResult.result(null, MyResult.FAIL_MESSAGE, MyResult.FAIL_CODE);
       }
    }

    /**
     * 删除货物
     * */
    @PostMapping("/deleteCargoById")
    public MyResult deleteCargoById(@RequestBody GetCargoDataForm form){
        Integer id = form.getId();
        try{
            cargoService.deleteCargoById(id);
            return MyResult.result(id, MyResult.SUCCESS_MESSAGE, MyResult.SUCCESS_CODE);
        }catch (Exception e){
            return MyResult.result(null, MyResult.FAIL_MESSAGE, MyResult.FAIL_CODE);
        }
    }

    /**
     * 根据货物名称或id查询货物
     * */
    @PostMapping("/getCargoByNameOrId")
    public MyResult getCargoByNameOrId(@RequestBody SearchCargosForm form){
        try{
            List<Cargo> cargoList = cargoService.getCargoByNameOrId(form);
            return MyResult.result(cargoList, MyResult.SUCCESS_MESSAGE, MyResult.SUCCESS_CODE);
        }catch (Exception e){
            return MyResult.result(null, MyResult.FAIL_MESSAGE, MyResult.FAIL_CODE);
        }
    }

    /**
     * 初始化修改
     * */
    @PostMapping("/iniEdit")
    public MyResult iniEdit(@RequestBody GetCargoDataForm form){
        try{
            Cargo cargo = cargoService.iniEdit(form.getId());
            return MyResult.result(cargo, MyResult.SUCCESS_MESSAGE, MyResult.SUCCESS_CODE);
        }catch (Exception e){
            return MyResult.result(null, MyResult.FAIL_MESSAGE, MyResult.FAIL_CODE);
        }
    }

    /**
     * 修改货物
     * */
    @PostMapping("/editCargo")
    public MyResult editCargo(@RequestBody Cargo cargo){
        try{
            cargoService.editCargo(cargo);
            return MyResult.result(cargo, MyResult.SUCCESS_MESSAGE, MyResult.SUCCESS_CODE);
        }catch (Exception e){
            return MyResult.result(null, MyResult.FAIL_MESSAGE, MyResult.FAIL_CODE);
        }
    }

}
