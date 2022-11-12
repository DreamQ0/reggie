package com.zcib.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcib.reggie.dto.SetmealDto;
import com.zcib.reggie.entity.Setmeal;

import java.util.List;

/**
 * @author 刘圣琦
 * @create 2022-11-05-0:20
 */
public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时需要保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);

    /**
     * 删除套餐
     * @param ids
     */
    void deleteByIds(List<Long> ids);

    //修改售卖状态
    public void statusByIds(int status, List<Long> ids);

    //修改套餐
    public void updateWithDish(SetmealDto setmealDto);
    //根据id查询套餐信息和对应的菜品信息
    SetmealDto getByIdWithDish(Long id);
}
