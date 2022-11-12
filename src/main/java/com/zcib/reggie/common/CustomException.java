package com.zcib.reggie.common;

/**
 * 自定义业务异常
 * @author 刘圣琦
 * @create 2022-11-05-1:11
 */
public class CustomException extends RuntimeException{
    public CustomException(String message){
        super(message);
    }
}
