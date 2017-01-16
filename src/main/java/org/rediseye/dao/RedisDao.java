package org.rediseye.dao;

import org.springframework.stereotype.Repository;

/**
 * Date: 2017/1/16 上午11:00
 * Usage:
 */
@Repository
public interface RedisDao {
    int saveNodeInfo();
    void getNodeInfoById(String id,long count);
}
