package com.zcib.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcib.reggie.entity.Orders;

/**
 * @author 刘圣琦
 * @create 2022-11-10-20:45
 */
public interface OrderService extends IService<Orders> {
    //用户下单
    public void submit(Orders orders);
}
