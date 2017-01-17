package org.rediseye.entity;


import java.util.Date;

/**
 * Date: 2017/1/16 上午11:49
 * Usage:
 */
public class NodeInfo {
    private Long id;
    private String nodeId; //节点Id
    private String info; //节点状态
    private Date time;//记录时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public NodeInfo(String nodeId, String info, Date time) {
        this.nodeId = nodeId;
        this.info = info;
        this.time = time;
    }

    public NodeInfo() {
    }
}
