package com.github.wz2cool.mybatisdynamicquerydemo.controller;

import com.github.pagehelper.PageInfo;
import com.github.wz2cool.mybatisdynamicquerydemo.model.entity.ProductsDO;
import com.github.wz2cool.mybatisdynamicquerydemo.service.NorthwindService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Frank
 * @date 2019/10/03
 **/
@RestController
@RequestMapping("price")
public class PriceController {

    @Resource
    private NorthwindService northwindService;

    @GetMapping
    public PageInfo<ProductsDO> getProductPageInfo(
            @RequestParam(value = "startPrice", required = false) BigDecimal startPrice,
            @RequestParam(value = "endPrice", required = false) BigDecimal endPrice,
            @RequestParam(value = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return northwindService.getProductPageInfo(startPrice, endPrice, pageNum, pageSize);
    }
}
