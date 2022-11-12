package com.zcib.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcib.reggie.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 刘圣琦
 * @create 2022-11-10-20:44
 */
@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
