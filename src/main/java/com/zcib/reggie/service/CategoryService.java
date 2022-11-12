package com.zcib.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcib.reggie.entity.Category;

/**
 * @author 刘圣琦
 * @create 2022-11-04-21:34
 */
public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
