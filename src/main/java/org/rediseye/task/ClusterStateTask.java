package org.rediseye.task;

import com.alibaba.fastjson.JSON;
import org.rediseye.Service.NodeInfoService;
import org.rediseye.Service.RedisService;
import org.rediseye.entity.NodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * Date: 2017/1/16 下午3:49
 * Usage:regular redis cluster info storage
 */
@Component
public class ClusterStateTask {
    @Autowired
    private NodeInfoService nodeInfoService;
    @Autowired
    private RedisService redisService;
    @Scheduled(cron="0/10 * * * * *")
    public void saveClusterInfo(){
        HashMap<String, Properties> infos= redisService.getNodeInfos();
        ArrayList<NodeInfo> nodeInfos=new ArrayList<>();
        for(Map.Entry<String, Properties> entry : infos.entrySet()){
           nodeInfos.add(new NodeInfo(entry.getKey(), JSON.toJSONString(entry.getValue()),new Date()));
        }
        nodeInfoService.saveNodeInfos(nodeInfos);
    }
    @Scheduled(cron="0 0 0 0/7 * *")//定期清理历史数据，保留最近七天数据
    public void deleteClusterInfo(){
        LocalDate localDate= LocalDate.now().plusDays(-7);
        Date date=Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        nodeInfoService.deleteNodeInfos(date);
    }
}
