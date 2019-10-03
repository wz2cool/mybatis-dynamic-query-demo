package com.github.wz2cool.mybatisdynamicquerydemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.wz2cool.dynamic.DynamicQuery;
import com.github.wz2cool.dynamic.FilterGroupDescriptor;
import com.github.wz2cool.dynamic.builder.DynamicQueryBuilder;
import com.github.wz2cool.mybatisdynamicquerydemo.mapper.ProductMapper;
import com.github.wz2cool.mybatisdynamicquerydemo.mapper.ProductPlusMapper;
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

import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.*;

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
    @Resource
    private ProductPlusMapper productPlusMapper;

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

        DynamicQuery<ProductsDO> query = DynamicQuery.createQuery(ProductsDO.class)
                .select(ProductsDO::getProductName, ProductsDO::getListPrice, ProductsDO::getCategory)
                .and(Objects.nonNull(startPrice) || Objects.nonNull(endPrice), group -> group
                        .and(Objects.nonNull(startPrice), ProductsDO::getListPrice, greaterThan(startPrice))
                        .and(Objects.nonNull(endPrice), ProductsDO::getListPrice, lessThan(endPrice)))
                .and(ProductsDO::getDescription, notEqual(null))
                .or(ProductsDO::getId, isEqual(1))
                .orderBy(ProductsDO::getId, desc())
                .orderBy(ProductsDO::getListPrice, asc());
        List<ProductsDO> result = productMapper.selectByDynamicQuery(query);
        Assert.assertFalse(result.isEmpty());

    }

    @Test
    public void testGetProductListByQuery3() {
        BigDecimal startPrice = BigDecimal.valueOf(1.1);
        BigDecimal endPrice = BigDecimal.valueOf(10.1);
        // 根据参数添加筛选条件，这里就是我们看看开始价，结束价有没有，如果有才会放到一个组里面，
        DynamicQuery<ProductsDO> query = DynamicQuery.createQuery(ProductsDO.class)
                .select(ProductsDO::getProductName, ProductsDO::getListPrice, ProductsDO::getCategory)
                .and(priceGroup -> priceGroup
                        .and(ProductsDO::getListPrice, greaterThan(startPrice))
                        .and(ProductsDO::getListPrice, lessThan(endPrice))
                        .and(idGroup -> idGroup
                                .and(ProductsDO::getId, greaterThan(1))
                                .and(ProductsDO::getId, lessThan(5))))
                .and(ProductsDO::getDescription, notEqual(null))
                .or(ProductsDO::getId, isEqual(1))
                .orderBy(ProductsDO::getId, desc())
                .orderBy(ProductsDO::getListPrice, asc());
        List<ProductsDO> result = productMapper.selectByDynamicQuery(query);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void testGetProductListByPlus() {
        BigDecimal startPrice = BigDecimal.valueOf(1.1);
        BigDecimal endPrice = BigDecimal.valueOf(10.1);
        LambdaQueryWrapper<ProductsDO> queryWrapper = new QueryWrapper<ProductsDO>().lambda()
                .select(ProductsDO::getListPrice, ProductsDO::getProductName, ProductsDO::getCategory);
        if (Objects.nonNull(startPrice) && Objects.nonNull(endPrice)) {
            // 这里我随意在筛选后面添加了一个排序是会报错的
            queryWrapper.and(obj -> obj.gt(ProductsDO::getListPrice, startPrice)
                    .lt(ProductsDO::getListPrice, endPrice).orderByAsc(ProductsDO::getListPrice));
        } else if (Objects.nonNull(startPrice)) {
            queryWrapper.gt(ProductsDO::getListPrice, startPrice);
        } else if (Objects.nonNull(endPrice)) {
            queryWrapper.lt(ProductsDO::getListPrice, startPrice);
        }

        queryWrapper.ne(ProductsDO::getDescription, null)
                .or(obj -> obj.eq(ProductsDO::getId, 1))
                .orderByDesc(ProductsDO::getId)
                .orderByAsc(ProductsDO::getListPrice);
        List<ProductsDO> result = productPlusMapper.selectList(queryWrapper);
        Assert.assertFalse(result.isEmpty());
    }
}
