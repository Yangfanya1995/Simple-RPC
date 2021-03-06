package com.simple.rpc.framework.zookeeper.message;

import java.io.Serializable;
import java.util.UUID;

/**
 * 引用服务的invoker信息对象:用于服务治理
 *
 * @author jacksu
 * @date 2018/8/8
 */
public class InvokerRegisterMessage implements Serializable {

    /**
     * 接口所在应用名
     */
    private String appName;
    /**
     * 接口的全限定名,用于寻找该标签信息存在哪个服务节点下,invoker节点本身不存储这个信息
     */
    private String servicePath;

    /**
     * 本机机器码:作为本机的身份证(一个机器会引用多个服务,因此在不同的服务节点下都会存储本机ID,这个ID是唯一的,在存节点的时候用)
     */
    private static String invokerMachineID4Client = UUID.randomUUID().toString();
    /**
     * 服务分组组名,默认值为"default"
     */
    private String groupName;

    /**
     * 服务治理时需要统计所有消费者节点的机器ID,这个时候得用对象属性区分(在读节点的时候用)
     */
    private String invokerMachineID4Server;

    public String getServicePath() {
        return servicePath;
    }

    public void setServicePath(String servicePath) {
        this.servicePath = servicePath;
    }


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public static String getInvokerMachineID4Client() {
        return invokerMachineID4Client;
    }

    public String getInvokerMachineID4Server() {
        return invokerMachineID4Server;
    }

    public void setInvokerMachineID4Server(String invokerMachineID4Server) {
        this.invokerMachineID4Server = invokerMachineID4Server;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public static void setInvokerMachineID4Client(String invokerMachineID4Client) {
        InvokerRegisterMessage.invokerMachineID4Client = invokerMachineID4Client;
    }
}



