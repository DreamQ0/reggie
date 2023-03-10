package com.zcib.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcib.reggie.entity.OrderDetail;
import com.zcib.reggie.mapper.OrderDetailMapper;
import com.zcib.reggie.service.OrderDetailService;
import org.springframework.stereotype.Service;

/**
 * @author 刘圣琦
 * @create 2022-11-10-20:47
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>  implements OrderDetailService {
}
