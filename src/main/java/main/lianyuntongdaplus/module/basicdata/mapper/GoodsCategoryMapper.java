package main.lianyuntongdaplus.module.basicdata.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import main.lianyuntongdaplus.module.basicdata.DO.GoodsCategoryDO;
import main.lianyuntongdaplus.module.basicdata.domain.GoodsCategory;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author UESAKA
 * @Description 货物分类mapper
 * @time 2025.8.12
 */
@Mapper
public interface GoodsCategoryMapper extends BaseMapper<GoodsCategory> {
    /**
     * 插入货物分类货物分类
     */
    @Insert("INSERT INTO goods_category (category_name, category_code, category_type, create_time, update_time) " + "VALUES (#{categoryName}, #{categoryCode}, #{categoryType}, NOW(), NOW())")
    void insertGoodsCategory(@Param("categoryName") String categoryName, @Param("categoryCode") Integer categoryCode, @Param("categoryType") String categoryType);

    /**
     * 删除货物分类
     */
    @Delete("DELETE FROM goods_category WHERE category_id = #{categoryId}")
    int deleteGoodsCategory(@Param("categoryId") Integer categoryId);

}