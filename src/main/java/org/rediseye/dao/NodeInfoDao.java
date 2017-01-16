package org.rediseye.dao;

import org.apache.ibatis.annotations.Param;
import org.rediseye.entity.NodeInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Date: 2017/1/16 下午1:15
 * Usage:
 */
@Repository
public interface NodeInfoDao {
    List<NodeInfo> getNodeInfoById(@Param("nodeId") String nodeId, @Param("count") long count);
    int saveNodeInfo(NodeInfo nodeInfo);
}
