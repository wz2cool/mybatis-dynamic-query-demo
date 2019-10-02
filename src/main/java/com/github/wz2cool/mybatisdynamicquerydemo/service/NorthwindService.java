package com.github.wz2cool.mybatisdynamicquerydemo.service;

import com.github.pagehelper.PageInfo;
import com.github.wz2cool.mybatisdynamicquerydemo.dao.ProductDAO;
import com.github.wz2cool.mybatisdynamicquerydemo.model.entity.ProductsDO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Frank
 * @date 2019/10/03
 **/
@Service
public class NorthwindService {
    @Resource
    private ProductDAO productDAO;

    public PageInfo<ProductsDO> getProductPageInfo(
            BigDecimal startPrice, BigDecimal endPrice, int pageNum, int pageSize) {
        return productDAO.getProductPageInfo(startPrice, endPrice, pageNum, pageSize);
    }
}
