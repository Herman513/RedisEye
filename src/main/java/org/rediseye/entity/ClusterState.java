package org.rediseye.entity;

import org.springframework.data.redis.connection.ClusterInfo;

/**
 * Date: 2016/12/30 下午4:57
 * Usage:
 */
public class ClusterState {
    private ClusterInfo clusterInfo;

    public ClusterState(ClusterInfo clusterInfo) {
        this.clusterInfo = clusterInfo;
    }
    private long keysCount;

    public Long getClusterSize(){
        return clusterInfo.getClusterSize();
    }

    public Long getSlotsOk(){
        return clusterInfo.getSlotsOk();
    }

    public Long getSlotsAssigned(){
        return clusterInfo.getSlotsAssigned();
    }
    public Long getKnownNodes(){
        return clusterInfo.getKnownNodes();
    }
    public Long getSlotsPfail(){
        return clusterInfo.getSlotsPfail();
    }
    public Long getSlotsFail(){
        return clusterInfo.getSlotsFail();
    }
    public String getState(){
        return clusterInfo.getState();
    }

    public long getKeysCount() {
        return keysCount;
    }

    public void setKeysCount(long keysCount) {
        this.keysCount = keysCount;
    }
}
