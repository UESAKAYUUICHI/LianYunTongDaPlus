package main.lianyuntongdaplus;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.module.basicdata.DO.GoodsCategoryDO;
import main.lianyuntongdaplus.module.basicdata.form.GoodsCategoryForm;
import main.lianyuntongdaplus.module.basicdata.mapper.GoodsCategoryMapper;
import main.lianyuntongdaplus.module.basicdata.domain.GoodsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author UESAKA
 * @Description null
 * @time 2025.7.29
 */
@SpringBootTest
@Transactional  // 添加事务注解，测试后自动回滚数据
public class GoodsCategoryTest  {

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;
//
//    @Test
//    public void selectById() {
//        GoodsCategory goodsCategory = goodsCategoryMapper.selectById(1);
//        System.out.println(goodsCategory);
//    }
//
//    @Test
//        public void select() {
//            //查询全部
//            goodsCategoryMapper.getAllGoodsCategory();
//            //根据类型模糊查询
//            goodsCategoryMapper.getGoodsCategoryByName("哈");
//            //根据父类型模糊查询
//            goodsCategoryMapper.getGoodsCategoryByParentName("猫");
//            //根据id查询
//            goodsCategoryMapper.getGoodsCategoryById(1);
//
//            System.out.println(goodsCategoryMapper.getAllGoodsCategory());
//            System.out.println(goodsCategoryMapper.getGoodsCategoryByName("哈"));
//            System.out.println(goodsCategoryMapper.getGoodsCategoryByParentName("猫"));
//            System.out.println(goodsCategoryMapper.getGoodsCategoryById(1));
//        }

}
