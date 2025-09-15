package main.lianyuntongdaplus.module.basicdata.controller;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.common.utils.result.MyResult;
import main.lianyuntongdaplus.common.utils.result.Result;
import main.lianyuntongdaplus.module.basicdata.DO.GoodsCategoryDO;
import main.lianyuntongdaplus.module.basicdata.form.GoodsCategoryForm;
import main.lianyuntongdaplus.module.basicdata.service.GoodsCategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static main.lianyuntongdaplus.common.utils.result.ResultCode.PARAM_IS_INVALID;
import static main.lianyuntongdaplus.common.utils.result.ResultCode.SYSTEM_ERROR;

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

    //已实现分页查询(丐版，等待重构)
    @PostMapping("/select")
    public Result select(@RequestBody GoodsCategoryForm goodsCategoryForm){
        List<GoodsCategoryDO> goodsCategoryList = goodsCategoryService.select(goodsCategoryForm);
        if(goodsCategoryList!=null){
            return Result.success(goodsCategoryList);
        }
        return Result.failure(PARAM_IS_INVALID.code(),PARAM_IS_INVALID.message());
    }

    /**
     * 增加
     * */

     @PostMapping("/add")
     public Result addGoodsCategory(@RequestBody GoodsCategoryForm goodsCategoryForm) {
         try {
             //此处不用判空，实体类拦截掉了
             goodsCategoryService.insertGoodsCategory(goodsCategoryForm);
             return Result.success("数据添加成功!");
         } catch (Exception e) {
             return Result.failure(SYSTEM_ERROR.code(), SYSTEM_ERROR.message());
         }
     }


     /**
     * 删除
     * */
    @PostMapping("/delete")
    public Result deleteGoodsCategory(@RequestParam Integer categoryId){
        try{
            goodsCategoryService.deleteGoodsCategory(categoryId);
            return Result.success("数据删除成功!");
        }catch(Exception e){
            return Result.failure(SYSTEM_ERROR.code(), SYSTEM_ERROR.message());
        }
    }

    /**
     * 更新
     * */

    @PostMapping("/updateGoodsCategory")
    public Result update(@RequestBody GoodsCategoryForm goodsCategoryForm){
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
                return Result.failure(SYSTEM_ERROR.code(), SYSTEM_ERROR.message());
            }
            goodsCategoryService.updateGoodsCategory(goodsCategoryForm);
            return Result.success("数据更新成功!");
        }catch(Exception e){
            return Result.failure(SYSTEM_ERROR.code(), SYSTEM_ERROR.message());
        }
    }
}
