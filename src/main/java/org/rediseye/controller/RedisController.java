package org.rediseye.controller;

import org.rediseye.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Date: 2016/12/14 下午7:03
 * Usage:
 */
@Controller
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping("/infos")
    @ResponseBody
    public HashMap<String, Object> getInfos() {
        return redisService.getInfo();
    }

    @RequestMapping("/redisInfo")
    public String redisInfo() {
        return "/redisInfo";
    }

    @RequestMapping(value = "/redis/keys", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteKey(@PathVariable(name = "key")String key) {
        return "ok";
    }

}
