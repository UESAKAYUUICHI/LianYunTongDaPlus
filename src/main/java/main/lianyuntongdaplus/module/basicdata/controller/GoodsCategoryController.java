package main.lianyuntongdaplus.module.basicdata.controller;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.common.utils.result.MyResult;
import main.lianyuntongdaplus.module.basicdata.DO.GoodsCategoryDO;
import main.lianyuntongdaplus.module.basicdata.domain.GoodsCategory;
import main.lianyuntongdaplus.module.basicdata.form.GoodsCategoryForm;
import main.lianyuntongdaplus.module.basicdata.service.GoodsCategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author UESAKA
 * @Description 货物分类控制器
 * @time 2025.8.29
 */
@RestController
@RequestMapping("/goodsCategory")
@Validated
public class GoodsCategoryController {

    @Resource
    private GoodsCategoryService goodsCategoryService;

    /**
     * 测试方法
     * */
    @GetMapping("/select")
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

     @PostMapping("/add")
     public MyResult addGoodsCategory(@RequestBody GoodsCategoryForm goodsCategoryForm) {
         try {
             //此处不用判空，实体类拦截掉了
             goodsCategoryService.insertGoodsCategory(goodsCategoryForm);
             return MyResult.result("货物分类添加成功",MyResult.SUCCESS_MESSAGE,MyResult.SUCCESS_CODE);
         } catch (Exception e) {
             return MyResult.result("货物分类添加失败",MyResult.FAIL_MESSAGE,MyResult.FAIL_CODE);
         }
     }


     /**
     * 删除
     * */
    @PostMapping("/delete")
    public MyResult deleteGoodsCategory(@RequestParam Integer categoryId){
        try{
            goodsCategoryService.deleteGoodsCategory(categoryId);
            return MyResult.result("货物分类删除成功",MyResult.SUCCESS_MESSAGE,MyResult.SUCCESS_CODE);
        }catch(Exception e){
            return MyResult.result("货物分类删除失败",MyResult.FAIL_MESSAGE,MyResult.FAIL_CODE);
        }

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
    public MyResult update(@RequestBody GoodsCategoryForm goodsCategoryForm){
        try{
            Integer id = goodsCategoryForm.getId();
            //设置非空判断标识符
            GoodsCategoryDO existingCategory;

            //因为selectById这个函数未查询到结果是error,不能使用==null判断非空
            try{
                existingCategory = goodsCategoryService.selectById(id);
            }catch(Exception e){
                existingCategory = null;
            }

            if(existingCategory == null){
                //可选择不存在的数据是否插入
                //goodsCategoryService.insertGoodsCategory(goodsCategoryForm);
                return MyResult.result(null,"商品分类不存在，无法修改！",MyResult.FAIL_CODE);
            }
            goodsCategoryService.updateGoodsCategory(goodsCategoryForm);
            return MyResult.result(goodsCategoryForm,"商品分类更新成功！",MyResult.SUCCESS_CODE);
        }catch(Exception e){
            return MyResult.result(null,"未知错误,请联系管理员！",MyResult.FAIL_CODE);
        }
    }
}
