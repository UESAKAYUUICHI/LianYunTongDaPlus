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

    private Integer id;

    private String categoryName;

    private Integer categoryCode;

    private String categoryType;

    private Date createTime;

    private Date updateTime;

}