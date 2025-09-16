package main.lianyuntongdaplus.module.basicdata.service.impl;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.module.basicdata.DO.GoodsCategoryDO;
import main.lianyuntongdaplus.module.basicdata.domain.GoodsCategory;
import main.lianyuntongdaplus.module.basicdata.form.GoodsCategoryForm;
import main.lianyuntongdaplus.module.basicdata.mapper.GoodsCategoryMapper;
import main.lianyuntongdaplus.module.basicdata.service.GoodsCategoryService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author UESAKA
 * @Description 货物分类服务实现类
 * @time 2025.8.12
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    /**
     * 查询大模块
     * @return 货物分类列表或单个对象
     * */
    @Override
    public List<GoodsCategoryDO> select(GoodsCategoryForm goodsCategoryForm) {

        //提取分页参数
        int pageNum = goodsCategoryForm.getPageNum();
        int pageSize = goodsCategoryForm.getPageSize();

        // 计算偏移量
        int offset = (pageNum - 1) * pageSize;

        // 使用 RowBounds 来设置分页参数
        RowBounds rowBounds = new RowBounds(offset, pageSize);

        // 优先根据ID查询
        if (goodsCategoryForm.getCategoryId() != null) {
            return goodsCategoryMapper.getGoodsCategoryById(goodsCategoryForm.getCategoryId());
        }

        //这里避免后面变量重复调用先提前提出来
        String categoryType = goodsCategoryForm.getCategoryType();
        String categoryParentType = goodsCategoryForm.getCategoryParentType();

        // 同时存在类型和父类型
        if (categoryType != null && categoryParentType != null) {
            return goodsCategoryMapper.getGoodsCategoryByNameAndParentName(categoryType, categoryParentType,rowBounds);
        }
        // 只有类型
        else if (categoryType != null) {
            return goodsCategoryMapper.getGoodsCategoryByName(categoryType,rowBounds);
        }
        // 只有父类型
        else if (categoryParentType != null) {
            return goodsCategoryMapper.getGoodsCategoryByParentName(categoryParentType,rowBounds);
        }
        // 都不存在则查询所有
        else {
            return goodsCategoryMapper.getAllGoodsCategory(rowBounds);
        }
    }


    //屎山之一，不可替代，没什么用，但是删了报错，在一些函数中有被使用，删除需要重构函数
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
    public void insertGoodsCategory(GoodsCategoryForm form) {
        RowBounds rowBounds = new RowBounds();
        if(goodsCategoryMapper.getGoodsCategoryByName(form.getCategoryType(),rowBounds).isEmpty()){
            // 从表单对象中提取参数
            goodsCategoryMapper.insertGoodsCategory(form.getCategoryType(),form.getCategoryParentType());
        }else{
            throw new IllegalArgumentException("错误");
        }

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
    public void updateGoodsCategory(GoodsCategoryForm form) {

        //提取参数
        Integer categoryId = form.getCategoryId();
        String categoryType = form.getCategoryType();
        String categoryParentType = form.getCategoryParentType();
        //设置非空判断标识符
        GoodsCategory existingCategory;

        //因为selectById这个函数未查询到结果是error,不能使用==null判断非空
        try{
            existingCategory = goodsCategoryMapper.selectById(categoryId);
        }catch(Exception e){
            existingCategory = null;
        }
        if(existingCategory == null){
            throw new IllegalArgumentException("错误");
        }
        goodsCategoryMapper.updateGoodsCategory(categoryId,categoryType,categoryParentType);
    }

}