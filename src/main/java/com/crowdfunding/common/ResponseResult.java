package com.crowdfunding.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
public class  ResponseResult<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    private ResponseResult(Integer code){
        this.code = code;
    }
    private ResponseResult(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
    private ResponseResult(Integer code,T data){
        this.data = data;
        this.code = code;
    }
    private ResponseResult(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static ResponseResult success(){
        return new ResponseResult(ResultEnum.SUCCESS.getCode());
    }
    public static ResponseResult success(String msg){
        return new ResponseResult(ResultEnum.SUCCESS.getCode(),msg);
    }
    public static <T> ResponseResult success(String msg,T data){
        return new ResponseResult(ResultEnum.SUCCESS.getCode(),msg,data);
    }
    public static <T> ResponseResult success(T data){
        return new ResponseResult(ResultEnum.SUCCESS.getCode(),data);
    }
    public static ResponseResult error(){
        return new ResponseResult(ResultEnum.ERROR.getCode());
    }
    public static ResponseResult error(String msg){
        return new ResponseResult(ResultEnum.ERROR.getCode(),msg);
    }
    public static <T> ResponseResult error(String msg,T data){
        return new ResponseResult(ResultEnum.ERROR.getCode(),msg,data);
    }
    public static <T> ResponseResult error(T data){
        return new ResponseResult(ResultEnum.ERROR.getCode(),data);
    }

}
