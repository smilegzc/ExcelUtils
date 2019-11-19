package com.smile.excelutils.mapper;


import com.smile.excelutils.entity.po.TtlProductInfoPo;

import java.util.List;
import java.util.Map;

public interface TtlProductInfoMapper {

    List<TtlProductInfoPo> listProduct(Map<String, Object> map);

}
