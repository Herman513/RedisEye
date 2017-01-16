package org.rediseye.controller;

/**
 * Date: 2017/1/16 下午2:39
 * Usage:
 */

import org.rediseye.Service.NodeInfoService;
import org.rediseye.entity.NodeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NodeInfoController {
    @Autowired
    private NodeInfoService nodeInfoService;
    @RequestMapping(value = "/nodes", method = RequestMethod.GET)
    public List<NodeInfo> getNodeInfo(@RequestParam("id") String id,@RequestParam("count") Long count){
        return nodeInfoService.getNodeInfoById(id,count);
    }
}
