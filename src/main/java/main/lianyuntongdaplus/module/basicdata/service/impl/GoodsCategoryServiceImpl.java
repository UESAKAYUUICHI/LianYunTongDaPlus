package main.lianyuntongdaplus.module.basicdata.service.impl;


import jakarta.annotation.Resource;
import main.lianyuntongdaplus.module.basicdata.mapper.GoodsCategoryMapper;
import main.lianyuntongdaplus.module.basicdata.domain.GoodsCategory;
import main.lianyuntongdaplus.module.basicdata.service.GoodsCategoryService;
import org.springframework.stereotype.Service;

/**
 * @Author UESAKA
 * @Description null
 * @time 2025.7.29
 */
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;



    @Override
    public GoodsCategory selectById(Integer id) {
        return goodsCategoryMapper.selectById(id);
    }

}
