package main.lianyuntongdaplus.module.basicdata.service;

import main.lianyuntongdaplus.module.basicdata.DO.GoodsCategoryDO;
import main.lianyuntongdaplus.module.basicdata.domain.GoodsCategory;
import main.lianyuntongdaplus.module.basicdata.form.GoodsCategoryForm;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author UESAKA
 * @Description 货物分类服务接口
 * @time 2025.8.12
 */
public interface GoodsCategoryService {
    GoodsCategoryDO selectById(Integer id);

    void insertGoodsCategory(@RequestBody GoodsCategoryForm goodsCategoryForm);

    void deleteGoodsCategory(Integer categoryId);

    void updateGoodsCategory(@RequestBody GoodsCategoryForm form);
}
