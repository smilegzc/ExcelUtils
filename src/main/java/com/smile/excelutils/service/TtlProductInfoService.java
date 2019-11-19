package com.smile.excelutils.service;

import com.smile.excelutils.entity.po.TtlProductInfoPo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface TtlProductInfoService {

    List<TtlProductInfoPo> listProduct(Map<String, Object> map);

    void export(HttpServletResponse response, String fileName);

}
