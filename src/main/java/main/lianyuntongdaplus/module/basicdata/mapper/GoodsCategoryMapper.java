package main.lianyuntongdaplus.module.basicdata.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import main.lianyuntongdaplus.module.basicdata.DO.GoodsCategoryDO;
import main.lianyuntongdaplus.module.basicdata.domain.GoodsCategory;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @Author UESAKA
 * @Description 货物分类mapper
 * @time 2025.8.12
 */
@Mapper
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {


    //查询

    /**
     * 根据ID查询货物分类
     */
    @Select("SELECT * FROM goods_category WHERE category_id = #{categoryId}")
    List<GoodsCategoryDO> getGoodsCategoryById(@Param("categoryId") Integer categoryId);

    /**
     * 根据名称模糊查询货物分类
     */
    @Select(" SELECT * FROM goods_category WHERE category_type LIKE CONCAT('%', #{categoryType}, '%') ")
    List<GoodsCategoryDO> getGoodsCategoryByName(@Param("categoryType") String categoryType, RowBounds rowBounds);

    /**
     * 根据父分类名称模糊查询货物分类
     */
    @Select("SELECT * FROM goods_category WHERE category_parent_type LIKE CONCAT('%', #{categoryParentType}, '%')")
    List<GoodsCategoryDO> getGoodsCategoryByParentName(@Param("categoryParentType") String categoryParentType, RowBounds rowBounds);

    /**
     * 根据分类名称和父分类名称联合模糊查询货物分类
     */
    @Select("SELECT * FROM goods_category WHERE category_type LIKE CONCAT('%', #{categoryType}, '%') AND category_parent_type LIKE CONCAT('%', #{categoryParentType}, '%')")
    List<GoodsCategoryDO> getGoodsCategoryByNameAndParentName(@Param("categoryType") String categoryType, @Param("categoryParentType") String categoryParentType, RowBounds rowBounds);

    /**
     * 查询所有货物分类
     */
    @Select("SELECT * FROM goods_category")
    List<GoodsCategoryDO> getAllGoodsCategory(RowBounds rowBounds);

    //更新

    /**
     * 更新货物分类
     */
    @Update("UPDATE goods_category SET category_type = #{categoryType}, category_parent_type = #{categoryParentType}, update_time = NOW() WHERE category_id = #{categoryId}")
    void updateGoodsCategory(@Param("categoryId") Integer categoryId,@Param("categoryType") String categoryType, @Param("categoryParentType") String categoryParentType);

    //插入


    /**
     * 插入货物分类
     */
    @Insert("INSERT INTO goods_category (category_type,category_parent_type, create_time, update_time) " + "VALUES (#{categoryType}, #{categoryParentType}, NOW(), NOW())")
    void insertGoodsCategory(@Param("categoryType") String categoryType, @Param("categoryParentType") String categoryParentType);

    //删除

    /**
     * 删除货物分类
     */
    @Delete("DELETE FROM goods_category WHERE category_id = #{categoryId}")
    void deleteGoodsCategory(@Param("categoryId") Integer categoryId);

}