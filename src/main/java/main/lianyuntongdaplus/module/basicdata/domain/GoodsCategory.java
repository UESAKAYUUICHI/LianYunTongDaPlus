package main.lianyuntongdaplus.module.basicdata.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author UESAKA
 * @Description 货物分类实体类
 * @time 2025.8.12
 */


@Data
@TableName("goods_category")
public class GoodsCategory implements Serializable {

    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名称
     */
    @TableField(value = "category_type")
    private String categoryType;

    /**
     * 父分类名称
     */
    @TableField(value = "category_parent_type")
    private String categoryParentType;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

}
