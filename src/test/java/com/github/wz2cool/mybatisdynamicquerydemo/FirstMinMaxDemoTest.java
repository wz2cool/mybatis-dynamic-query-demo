package com.github.wz2cool.mybatisdynamicquerydemo;

import com.github.wz2cool.dynamic.DynamicQuery;
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
import java.util.Optional;

import static com.github.wz2cool.dynamic.builder.DynamicQueryBuilderHelper.*;

/**
 * @author Frank
 * @date 2019/11/20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = MybatisDynamicQueryDemoApplication.class)
public class FirstMinMaxDemoTest {

    @Resource
    private ProductMapper productMapper;

    @Test
    public void testSelectFirst() {
        DynamicQuery<ProductsDO> query = DynamicQuery.createQuery(ProductsDO.class)
                .and(ProductsDO::getId, greaterThan(2))
                .orderBy(ProductsDO::getId, asc());
        // 因为过滤掉了2 ， 再按照id 升序，那么第二个id值一定是3
        Optional<ProductsDO> productsDOOptional = productMapper.selectFirstByDynamicQuery(query);
        Assert.assertTrue(productsDOOptional.isPresent());
        Integer expectedValue = 3;
        Integer actualValue = productsDOOptional.get().getId();
        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testSelectMax() {
        // 查看最大值的比较可以用，我们倒叙获得的值和最大值进行比较
       /* --  12  2019-11-20 22:51:57.634 DEBUG 11812 --- [           main] c.g.w.m.m.P.selectMaxByDynamicQuery      : ==>
        SELECT MAX(list_price)
                FROM products
        WHERE (id > 10);
        ------------------------------------------------------------------------------------------------------------------------
                --  13  2019-11-20 22:51:58.508 DEBUG 11812 --- [           main] .g.w.m.m.P.selectRowBoundsByDynamicQuery : ==>
        SELECT list_price AS list_price
        FROM products
        WHERE (id > 10) ORDER BY list_price DESC
        LIMIT 1;*/

        DynamicQuery<ProductsDO> selectMaxQuery = DynamicQuery.createQuery(ProductsDO.class)
                .and(ProductsDO::getId, greaterThan(10));
        Optional<BigDecimal> maxPriceOptional =
                productMapper.selectMaxByDynamicQuery(ProductsDO::getListPrice, selectMaxQuery);
        Assert.assertTrue(maxPriceOptional.isPresent());
        BigDecimal actualMaxPrice = maxPriceOptional.get();

        DynamicQuery<ProductsDO> selectFirstQuery = DynamicQuery.createQuery(ProductsDO.class)
                .select(ProductsDO::getListPrice)
                .and(ProductsDO::getId, greaterThan(10))
                .orderBy(ProductsDO::getListPrice, desc());
        Optional<ProductsDO> productsDOOptional = productMapper.selectFirstByDynamicQuery(selectFirstQuery);
        Assert.assertTrue(productsDOOptional.isPresent());
        BigDecimal expectedMaxPrice = productsDOOptional.get().getListPrice();

        Assert.assertEquals(expectedMaxPrice, actualMaxPrice);
    }
}
