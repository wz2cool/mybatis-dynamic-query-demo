package com.github.wz2cool.mybatisdynamicquerydemo.mapper;

import com.github.wz2cool.dynamic.mybatis.mapper.DynamicQueryMapper;
import com.github.wz2cool.mybatisdynamicquerydemo.model.entity.ProductsDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Frank
 * @date 2019/10/02
 **/
@Mapper
public interface ProductMapper extends DynamicQueryMapper<ProductsDO> {
}
