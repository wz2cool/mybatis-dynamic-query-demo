package com.github.wz2cool.mybatisdynamicquerydemo;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.FilterGroupDescriptor;
import com.github.wz2cool.dynamic.builder.DynamicQueryBuilder;
import com.github.wz2cool.mybatisdynamicquerydemo.mapper.ProductMapper;
import com.github.wz2cool.mybatisdynamicquerydemo.model.entity.ProductsDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.*;
import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.asc;

/**
 * @author Frank
 * @date 2019/10/03
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MybatisDynamicQueryDemoApplication.class)
public class DemoTest {

    @Resource
    private ProductMapper productMapper;

    public List<ProductsDO> getProductListByBuilder() {
        // select product_name, list_price, category
        // where (list_price > 1 and list_price < 10) and description is not null or id = 1
        // order by id desc, list_price asc
        DynamicQuery<ProductsDO> query = DynamicQueryBuilder.create(ProductsDO.class)
                .select(ProductsDO::getProductName, ProductsDO::getListPrice, ProductsDO::getCategory)
                .where(ProductsDO::getListPrice, greaterThan(BigDecimal.ONE),
                        and(ProductsDO::getListPrice, lessThan(BigDecimal.TEN)))
                .and(ProductsDO::getDescription, notEqual(null))
                .or(ProductsDO::getId, isEqual(1))
                .orderBy(ProductsDO::getId, desc())
                .thenBy(ProductsDO::getListPrice, asc())
                .build();
        return productMapper.selectByDynamicQuery(query);
    }


    @Test
    public void testGetProductListByQuery() {
        BigDecimal startPrice = BigDecimal.valueOf(1.1);
        BigDecimal endPrice = BigDecimal.valueOf(10.1);
        DynamicQuery<ProductsDO> query = DynamicQuery.createQuery(ProductsDO.class)
                .select(ProductsDO::getProductName, ProductsDO::getListPrice, ProductsDO::getCategory);
        // 根据参数添加筛选条件，这里就是我们看看开始价，结束价有没有，如果有才会放到一个组里面，
        if (Objects.nonNull(startPrice) || Objects.nonNull(endPrice)) {
            FilterGroupDescriptor<ProductsDO> priceFilterGroup = new FilterGroupDescriptor<>();
            if (Objects.nonNull(startPrice)) {
                priceFilterGroup.and(ProductsDO::getListPrice, greaterThan(startPrice));
            }
            Optional<BigDecimal> endPriceOptional = Optional.ofNullable(endPrice);
            endPriceOptional.ifPresent(bigDecimal -> priceFilterGroup.and(ProductsDO::getListPrice, greaterThan(bigDecimal)));
            query.addFilters(priceFilterGroup);
        }
        query.and(ProductsDO::getDescription, notEqual(null))
                .or(ProductsDO::getId, isEqual(1))
                .orderBy(ProductsDO::getId, desc())
                .orderBy(ProductsDO::getListPrice, asc());
        List<ProductsDO> result = productMapper.selectByDynamicQuery(query);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void testGetProductListByQuery2() {
        BigDecimal startPrice = BigDecimal.valueOf(1.1);
        BigDecimal endPrice = BigDecimal.valueOf(10.1);
        // 根据参数添加筛选条件，这里就是我们看看开始价，结束价有没有，如果有才会放到一个组里面，
        // @formatter:off
        DynamicQuery<ProductsDO> query = DynamicQuery.createQuery(ProductsDO.class)
                .select(ProductsDO::getProductName, ProductsDO::getListPrice, ProductsDO::getCategory)
                .andGroupBegin(Objects.nonNull(startPrice) || Objects.nonNull(endPrice))
                    .and(ProductsDO::getListPrice, greaterThan(startPrice), Objects.nonNull(startPrice))
                    .and(ProductsDO::getListPrice, lessThan(endPrice), Objects.nonNull(endPrice))
                .groupEnd()
                .and(ProductsDO::getDescription, notEqual(null))
                .or(ProductsDO::getId, isEqual(1))
                .orderBy(ProductsDO::getId, desc())
                .orderBy(ProductsDO::getListPrice, asc());
        List<ProductsDO> result = productMapper.selectByDynamicQuery(query);
        Assert.assertFalse(result.isEmpty());
        // @formatter:on
    }
}
