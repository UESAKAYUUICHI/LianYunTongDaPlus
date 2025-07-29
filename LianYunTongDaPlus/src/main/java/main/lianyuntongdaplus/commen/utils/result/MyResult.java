package main.lianyuntongdaplus.commen.utils.result;

/**
 * 统一返回结果
 * */
public class MyResult {
    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;
    public static final String SUCCESS_MESSAGE = "success";
    public static final String FAIL_MESSAGE = "fail";

    private Object data;
    private String message;
    private int code;

    public static MyResult result(Object data, String message, int code) {
        MyResult myResult = new MyResult();
        myResult.setData(data);
        myResult.setMessage(message);
        myResult.setCode(code);
        return myResult;
    }

    // Getter 和 Setter 方法
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
