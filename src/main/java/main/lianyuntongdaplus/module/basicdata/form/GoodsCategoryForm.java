package main.lianyuntongdaplus.module.basicdata.form;


import lombok.Data;

import java.util.Date;

/**
 * @Author UESAKA
 * @Description 货物分类表单
 * @time 2025.8.12
 */
@Data
public class GoodsCategoryForm {

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