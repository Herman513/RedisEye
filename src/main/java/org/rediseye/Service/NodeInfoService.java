package org.rediseye.Service;

import org.rediseye.dao.NodeInfoDao;
import org.rediseye.entity.NodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Date: 2017/1/16 下午2:36
 * Usage:
 */
@Service
public class NodeInfoService {
    @Autowired
    NodeInfoDao nodeInfoDao;
    public List<NodeInfo> getNodeInfoById(String nodeId, Long count) {
       return nodeInfoDao.getNodeInfoById(nodeId,count);
    }
    public int saveNodeInfos(List<NodeInfo> nodeInfos){
        return nodeInfoDao.saveNodeInfos(nodeInfos);
    }
    public int deleteNodeInfos(Date date){//删除date之前的数据
        return nodeInfoDao.deleteNodeInfos(date);
    }
}
