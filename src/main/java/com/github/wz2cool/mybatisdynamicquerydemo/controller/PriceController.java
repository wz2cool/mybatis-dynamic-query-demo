package com.github.wz2cool.mybatisdynamicquerydemo.controller;

import com.github.wz2cool.mybatisdynamicquerydemo.service.NorthwindService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Frank
 * @date 2019/10/03
 **/
@RestController
@RequestMapping("price")
public class PriceController {

    @Resource
    private NorthwindService northwindService;


}
