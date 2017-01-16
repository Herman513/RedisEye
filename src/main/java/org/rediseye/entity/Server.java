package org.rediseye.entity;

/**
 * Date: 2016/12/14 下午6:26
 * Usage:
 */
public class Server {
    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Server() {
    }

    public Server(String host, int port) {
        this.host = host;
        this.port = port;
    }
}
