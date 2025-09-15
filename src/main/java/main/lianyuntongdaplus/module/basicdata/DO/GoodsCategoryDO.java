package main.lianyuntongdaplus.module.basicdata.DO;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author UESAKA
 * @Description 货物分类数据对象
 * @time 2025.8.12
 */

@Data
public class GoodsCategoryDO {

    private Integer categoryId;

    /**
     * 分类名称
     */
    private String categoryType;

    /**
     * 父分类名称
     */
    private String categoryParentType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}