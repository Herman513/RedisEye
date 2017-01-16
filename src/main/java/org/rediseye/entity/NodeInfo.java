package org.rediseye.entity;

import java.sql.Timestamp;

/**
 * Date: 2017/1/16 上午11:49
 * Usage:
 */
public class NodeInfo {
    private Long id;
    private String nodeId; //节点Id
    private String info; //节点状态
    private Timestamp time;//记录时间

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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
