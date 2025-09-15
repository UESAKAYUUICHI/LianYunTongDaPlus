package main.lianyuntongdaplus.module.basicdata.controller;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.common.utils.result.MyResult;
import main.lianyuntongdaplus.module.basicdata.DO.GoodsCategoryDO;
import main.lianyuntongdaplus.module.basicdata.form.GoodsCategoryForm;
import main.lianyuntongdaplus.module.basicdata.service.GoodsCategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
     * 查询大模块，根据categoryId,categoryType,categoryParentType来查询
     * @param goodsCategoryForm 包含查询条件的表单对象
     * categoryId: 分类ID 精确查询
     * categoryType: 分类类型 模糊查询
     * categoryParentType: 父分类类型 模糊查询
     * @return 包含查询结果的 MyResult 对象
     * */

    //目前希望改进的方向为分页查询

    @PostMapping("/select")
    public MyResult select(@RequestBody GoodsCategoryForm goodsCategoryForm){
        List<GoodsCategoryDO> goodsCategoryList = goodsCategoryService.select(goodsCategoryForm);
        if(goodsCategoryList!=null){
            return MyResult.result(goodsCategoryList,MyResult.SUCCESS_MESSAGE,MyResult.SUCCESS_CODE);
        }
        return MyResult.result("列表为空或查询错误",MyResult.FAIL_MESSAGE,MyResult.FAIL_CODE);
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
     * 更新
     * */

    @PostMapping("/updateGoodsCategory")
    public MyResult update(@RequestBody GoodsCategoryForm goodsCategoryForm){
        try{
            Integer id = goodsCategoryForm.getCategoryId();
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
