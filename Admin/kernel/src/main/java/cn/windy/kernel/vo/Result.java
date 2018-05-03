package cn.windy.kernel.vo;

import cn.windy.kernel.model.BaseModel;

/**
 * 返回页面数据结果
 */
public class Result {

    private BaseModel model;
    private String code = "200";
    private String message = "";

    public BaseModel getModel() {
        return model;
    }

    public void setModel(BaseModel model) {
        this.model = model;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
