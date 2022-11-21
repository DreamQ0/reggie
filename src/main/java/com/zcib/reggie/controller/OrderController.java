package com.zcib.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcib.reggie.common.R;
import com.zcib.reggie.dto.OrdersDto;
import com.zcib.reggie.dto.SetmealDto;
import com.zcib.reggie.entity.Category;
import com.zcib.reggie.entity.Orders;
import com.zcib.reggie.entity.Setmeal;
import com.zcib.reggie.service.CategoryService;
import com.zcib.reggie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单
 *
 * @author 刘圣琦
 * @create 2022-11-10-20:57
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    /**
     * 用户下单
     *
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders) {
        log.info("订单数据：{}", orders);
        orderService.submit(orders);
        return R.success("下单成功");
    }
    /**
     * 用户订单查询
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping("/userPage")
    public R<Page> page(int page, int pageSize){

        //分页构造器对象
        Page<Orders> pageInfo = new Page<>(page,pageSize);
        //构造条件查询对象
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();

        //添加排序条件，根据更新时间降序排列
        queryWrapper.orderByDesc(Orders::getOrderTime);
        orderService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    /**
     * 后端查看订单
     * @param page
     * @param pageSize
     * @param number
     * @param beginTime
     * @param endTime
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize,String number,String beginTime,String endTime) {
        //构造分页构造器
        Page<Orders> pageInfo = new Page<>(page, pageSize);
        Page<OrdersDto> ordersDtoPage = new Page<>();
        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        //添加过滤条件
        queryWrapper.like(number!=null,Orders::getNumber,number);
        queryWrapper.ge(StringUtils.isNotEmpty(beginTime), Orders::getOrderTime, beginTime);//ge ：大于等于 >=
        queryWrapper.le(StringUtils.isNotEmpty(endTime), Orders::getOrderTime, endTime);//le ：小于等于 <=
        orderService.page(pageInfo, queryWrapper);
        //对象拷贝
        BeanUtils.copyProperties(pageInfo, ordersDtoPage, "records");
        List<Orders> records = pageInfo.getRecords();

        List<OrdersDto> list = records.stream().map((item) -> {
            OrdersDto ordersDto = new OrdersDto();
            BeanUtils.copyProperties(item, ordersDto);
            String userName = item.getConsignee();
            ordersDto.setUserName(userName);
            return ordersDto;
        }).collect(Collectors.toList());

        ordersDtoPage.setRecords(list);


        return R.success(ordersDtoPage);
    }

    /**
     * 订单状态修改
     * @param orders
     * @return
     */
    @PutMapping
    public R<String> status(@RequestBody Orders orders ){
        Long orderId = orders.getId();
        Integer status = orders.getStatus();

        if(orderId == null || status==null){
            return R.error("传入信息不合法");
        }

        LambdaQueryWrapper<Orders> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Orders::getId, orderId);
        Orders one = orderService.getOne(queryWrapper);
        one.setStatus(status);

        orderService.updateById(one);
        return R.success("状态修改成功");
    }

}
