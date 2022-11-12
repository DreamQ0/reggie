package com.zcib.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcib.reggie.entity.ShoppingCart;
import com.zcib.reggie.mapper.ShoppingCartMapper;
import com.zcib.reggie.service.ShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * @author 刘圣琦
 * @create 2022-11-10-16:33
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {
}
