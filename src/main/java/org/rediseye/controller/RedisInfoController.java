package org.rediseye.controller;

import org.rediseye.Service.RedisInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Date: 2016/12/14 下午7:03
 * Usage:
 */
@Controller
public class RedisInfoController {
    @Autowired
    private RedisInfoService redisInfoService;

    @RequestMapping("/infos")
    @ResponseBody
    public HashMap<String, Object> getInfos() {
        return redisInfoService.getInfo();
    }

    @RequestMapping("/redisInfo")
    public String redisInfo() {
        return "/redisInfo";
    }
}
