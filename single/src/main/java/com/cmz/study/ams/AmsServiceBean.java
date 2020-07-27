package com.cmz.study.ams;

import java.util.List;

/**
 * Created by lsj on 2018/5/22.
 */
public class AmsServiceBean {
    private static final String COMMON_GRPC_CLASS_NAME = "com.apex.ams.common.CommonGrpc";

    private String domain;
    private String serviceName;
    private String version;
    private String source;
    private String grpcClass;
    private String loadTime;
    private List<AmsFuncBean> funcList;

    public String getDomain() {
        return domain;
    }

    public String getGrpcClass() {
        return grpcClass;
    }

    public void setGrpcClass(String grpcClass) {
        this.grpcClass = grpcClass;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<AmsFuncBean> getFuncList() {
        return funcList;
    }

    public void setFuncList(List<AmsFuncBean> funcList) {
        this.funcList = funcList;
    }

    public String getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(String loadTime) {
        this.loadTime = loadTime;
    }

    public String getKey(){
        if(null!=domain && domain.length()>0){
            return domain+":"+serviceName;
        }
        return serviceName;
    }
    public boolean isCommonGrpcService(){
        return COMMON_GRPC_CLASS_NAME.equals(getGrpcClass());
    }

}
