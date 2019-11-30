package com.smile.excelutils.controller;

import com.smile.excelutils.service.TtlProductInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@RestController
@RequestMapping("/excelUtils")
public class ExportController {

    @Resource
    private TtlProductInfoService productInfoService;

    @GetMapping("/export")
    public void export(HttpServletResponse response) {
        this.productInfoService.export(response, "商品信息" + new Random().nextInt(1000));
    }

}
