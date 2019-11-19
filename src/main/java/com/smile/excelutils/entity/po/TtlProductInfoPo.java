package com.smile.excelutils.entity.po;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TtlProductInfoPo {

    private Long id;
    private String productName;
    private Long categoryId;
    private String categoryName;
    private Long branchId;
    private String branchName;
    private Long shopId;
    private String shopName;
    private Double price;
    private Integer stock;
    private Integer salesNum;
    private String createTime;
    private String updateTime;
    private Byte isDel;

}
