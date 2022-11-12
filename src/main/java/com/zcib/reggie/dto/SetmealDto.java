package com.zcib.reggie.dto;

import com.zcib.reggie.entity.Setmeal;
import com.zcib.reggie.entity.SetmealDish;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO:全称为Data Transfer Object，即数据传输对象，一般用于展示层与服务层之间的数据传输
 */
@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes = new ArrayList<>();

    private String categoryName;
}
