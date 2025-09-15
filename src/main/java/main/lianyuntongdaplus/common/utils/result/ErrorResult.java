package main.lianyuntongdaplus.common.utils.result;


import lombok.Data;

/**
 * @Author UESAKA
 * @Description null
 * @time 2025.7.29
 */
@Data
public class ErrorResult {
    private Integer code;
    private String message;

    public ErrorResult(Integer code, String message){
        this.code = code;
        this.message = message;
    }

}
