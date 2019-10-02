package com.github.wz2cool.mybatisdynamicquerydemo.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.mybatisdynamicquerydemo.mapper.ProductMapper;
import com.github.wz2cool.mybatisdynamicquerydemo.model.entity.ProductsDO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Objects;

import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.*;

/**
 * @author Frank
 * @date 2019/10/03
 **/
@Repository
public class ProductDAO {

    @Resource
    private ProductMapper productMapper;

    public PageInfo<ProductsDO> getProductPageInfo(
            BigDecimal startPrice, BigDecimal endPrice, int pageNum, int pageSize) {
        DynamicQuery<ProductsDO> query = DynamicQuery.createQuery(ProductsDO.class);

        if (Objects.nonNull(startPrice)) {
            query.and(ProductsDO::getListPrice, greaterThanOrEqual(startPrice));
        }

        if (Objects.nonNull(endPrice)) {
            query.and(ProductsDO::getListPrice, lessThanOrEqual(endPrice));
        }

        query.sort(ProductsDO::getId, desc());
        return PageHelper.startPage(pageNum, pageSize, true)
                .doSelectPageInfo(() -> productMapper.selectByDynamicQuery(query));
    }
}
