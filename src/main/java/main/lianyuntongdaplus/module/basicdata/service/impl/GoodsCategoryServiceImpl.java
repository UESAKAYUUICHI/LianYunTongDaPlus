package main.lianyuntongdaplus.module.basicdata.service.impl;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.module.basicdata.DO.GoodsCategoryDO;
import main.lianyuntongdaplus.module.basicdata.domain.GoodsCategory;
import main.lianyuntongdaplus.module.basicdata.form.GoodsCategoryForm;
import main.lianyuntongdaplus.module.basicdata.mapper.GoodsCategoryMapper;
import main.lianyuntongdaplus.module.basicdata.service.GoodsCategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author UESAKA
 * @Description 货物分类服务实现类
 * @time 2025.8.12
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public GoodsCategoryDO selectById(Integer id) {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectById(id);
        GoodsCategoryDO goodsCategoryDO = new GoodsCategoryDO();
        BeanUtils.copyProperties(goodsCategory,goodsCategoryDO);
        return goodsCategoryDO;
    }


    /**
     * 新增货物分类
     * @param form 货物分类表单
     * */
    @Override
    public void insertGoodsCategory(@RequestBody GoodsCategoryForm form) {
        // 从表单对象中提取参数
        goodsCategoryMapper.insertGoodsCategory(form.getCategoryName(),form.getCategoryCode(),form.getCategoryType());
    }

    /**
     * 删除货物分类
     * @param categoryId 货物分类id
     * */
    @Override
    public void deleteGoodsCategory(Integer categoryId) {
        goodsCategoryMapper.deleteGoodsCategory(categoryId);
    }

    /**
     * 更新货物分类
     * @param form 货物分类表单
     * */
    @Override
    public void updateGoodsCategory(@RequestBody GoodsCategoryForm form) {
        GoodsCategory goodsCategory = new GoodsCategory();
        BeanUtils.copyProperties(form,goodsCategory);
        goodsCategoryMapper.updateById(goodsCategory);
    }

}