package com.github.wz2cool.mybatisdynamicquerydemo.dao;

import com.github.wz2cool.mybatisdynamicquerydemo.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author Frank
 * @date 2019/10/03
 **/
@Repository
public class ProductDAO {

    @Resource
    private ProductMapper productMapper;





}
