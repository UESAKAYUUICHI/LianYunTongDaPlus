package main.lianyuntongdaplus.common.utils.result;


import lombok.Data;

import java.io.Serializable;

/**
 * @Author UESAKA
 * @Description 重置版本的接口返回集
 * @time 2025.9.15
 */
// 成功结果实体
@Data
public class Result<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public void setResultCode(ResultCode resultCode) {
        this.code = resultCode.code();
    }

    public static Result success() {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        return result;
    }

    public static<T> Result success(T data) {
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setCode(ResultCode.SUCCESS.code());
        result.setMessage(ResultCode.SUCCESS.message());
        result.setData(data);
        return result;
    }

    public static Result failure(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}