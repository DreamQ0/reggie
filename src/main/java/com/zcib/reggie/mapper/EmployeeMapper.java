package com.zcib.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcib.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 刘圣琦
 * @create 2022-11-02-14:32
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
