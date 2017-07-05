package com.creditcrest.ccs.common.pojo;

/** 前台json实体
 * Created by 柏世民 on 2017/7/3.
 */
public class AjaxResult {
    //默认成功 : 1
    private int retcode = 1;
    //默认操作成功
    private String retMsg = "操作成功";
    //返回结果
    private Object data;

    public AjaxResult(int retcode, String retMsg, Object data) {
        this.retcode = retcode;
        this.retMsg = retMsg;
        this.data = data;
    }

    public AjaxResult(int retcode, String retMsg) {
        this.retcode = retcode;
        this.retMsg = retMsg;
    }

    public AjaxResult(String retMsg) {
        this.retcode = 0;
        this.retMsg = retMsg;
    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
