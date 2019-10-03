package com.github.wz2cool.mybatisdynamicquerydemo.service;

import com.github.wz2cool.mybatisdynamicquerydemo.dao.ProductDAO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Frank
 * @date 2019/10/03
 **/
@Service
public class NorthwindService {
    @Resource
    private ProductDAO productDAO;

}
