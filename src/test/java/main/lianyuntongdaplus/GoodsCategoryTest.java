package main.lianyuntongdaplus;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.module.basicdata.mapper.GoodsCategoryMapper;
import main.lianyuntongdaplus.module.basicdata.domain.GoodsCategory;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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

    @Test
    public void selectById() {
        GoodsCategory goodsCategory = goodsCategoryMapper.selectById(1);
        System.out.println(goodsCategory);
    }
}
