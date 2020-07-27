package com.cmz.study.ams;


import java.util.List;

/**
 * Created by lsj on 2018/5/22.
 */
public class AmsFuncBean {

    private String funcName;
    private List<AmsParamBean> inParam;
    private AmsParamBean outParam;

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public List<AmsParamBean> getInParam() {
        return inParam;
    }

    public void setInParam(List<AmsParamBean> inParam) {
        this.inParam = inParam;
    }

    public AmsParamBean getOutParam() {
        return outParam;
    }

    public void setOutParam(AmsParamBean outParam) {
        this.outParam = outParam;
    }
}
