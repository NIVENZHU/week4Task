package com.bytedance.week4.common;

import com.bytedance.week4.exception.bdExceptionEnum;

/**
 * 统一响应restful
 * @param <T>
 */
public class ApiRestResponse<T> {
    private Integer code;
    private String msg;
    private T data;
    private Integer total;


    //发生异常和成功无返回
    public ApiRestResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    //获取列表成功
    public ApiRestResponse(T data,Integer total){
        this.data=data;
        this.total =total;
    }

    //获取单个数据
    public ApiRestResponse(T data){
        this.data = data;
    }

    //1.成功返回单个
    public static <T> ApiRestResponse<T> success(T data){
        return new ApiRestResponse<>(data);
    }

    //2.成功返回多个
    public static <T> ApiRestResponse<T> success(T data,Integer total){
        return new ApiRestResponse<>(data,total);
    }
    //3. 无返回且成功
    public static <T> ApiRestResponse<T> success(){
        return new ApiRestResponse<>(Constant.SUCCESS_CODE,Constant.SUCCESS_MSG);
    }
    //4. 异常（枚举类返回）
    public static <T> ApiRestResponse<T> error(bdExceptionEnum ex){
        return new ApiRestResponse<>(ex.getCode(),ex.getMsg());
    }
    //5. 异常（自定义返回）
    public static <T> ApiRestResponse<T> error(Integer code,String msg){
        return new ApiRestResponse<>(code,msg);
    }

    public Integer getCode() {
        return code;
    }

    public void setErr(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
