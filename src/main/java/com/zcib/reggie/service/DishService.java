package com.zcib.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcib.reggie.dto.DishDto;
import com.zcib.reggie.entity.Dish;

import java.util.List;

/**
 * @author 刘圣琦
 * @create 2022-11-05-0:20
 */
public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish dish_flavor
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);

    //根据传过来的id批量或者是单个的删除菜品
    public void deleteByIds(List<Long> ids);

    //修改售卖状态
    public void statusByIds(int status, List<Long> ids);
}
