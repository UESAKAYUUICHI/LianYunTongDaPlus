package main.lianyuntongdaplus.module.basicdata.service;

import main.lianyuntongdaplus.module.basicdata.DO.GoodsCategoryDO;
import main.lianyuntongdaplus.module.basicdata.domain.GoodsCategory;
import main.lianyuntongdaplus.module.basicdata.form.GoodsCategoryForm;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @Author UESAKA
 * @Description 货物分类服务接口
 * @time 2025.8.12
 */
public interface GoodsCategoryService {
    GoodsCategoryDO selectById(Integer id);

    List<GoodsCategoryDO> select(GoodsCategoryForm goodsCategoryForm);

    void insertGoodsCategory(GoodsCategoryForm goodsCategoryForm);

    void deleteGoodsCategory(Integer categoryId);

    void updateGoodsCategory(GoodsCategoryForm form);
}
