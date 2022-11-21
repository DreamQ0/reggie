package com.zcib.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcib.reggie.entity.OrderDetail;

import java.util.List;

/**
 * @author 刘圣琦
 * @create 2022-11-10-20:46
 */
public interface OrderDetailService extends IService<OrderDetail> {
    List<OrderDetail> getByOrderId(Long id);
}
