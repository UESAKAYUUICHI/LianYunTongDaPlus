package main.lianyuntongdaplus.module.basicdata.controller;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.common.utils.result.MyResult;
import main.lianyuntongdaplus.module.basicdata.service.GoodsCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author UESAKA
 * @Description null
 * @time 2025.8.29
 */
@RestController
public class GoodsCategoryController {

    @Resource
    private GoodsCategoryService goodsCategoryService;

    /**
     * 测试方法
     * */
    @GetMapping("/test")
    public MyResult test(@RequestParam Integer id){
        if(goodsCategoryService.selectById(id) == null){
            return MyResult.result(null,"商品分类不存在",MyResult.FAIL_CODE);
        }else{
            return MyResult.result(goodsCategoryService.selectById(id),MyResult.SUCCESS_MESSAGE,MyResult.SUCCESS_CODE);
        }
    }

    /**
     * 增加
     * */

     @PostMapping("/addGoodsCategory")
     public MyResult add(){
         return MyResult.result();
     }


     /**
     * 删除
     * */
    @PostMapping("/deleteGoodsCategory")
    public MyResult delete(){
        return MyResult.result();
    }

    /**
     * 分页查询
     * */
    @PostMapping("/pageGoodsCategory")
    public MyResult page(){
        return MyResult.result();
    }

    /**
     * 更新
     * */
    @PostMapping("/updateGoodsCategory")
    public MyResult update(){
        return MyResult.result();
    }

}
