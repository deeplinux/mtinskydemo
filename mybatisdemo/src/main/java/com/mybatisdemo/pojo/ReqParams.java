package com.mybatisdemo.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 17-2-6
 * Time: 上午11:52
 * To change this template use File | Settings | File Templates.
 */
public class ReqParams {
    private int status;
    private int type;
    private int quality;
    private int start;
    private int limit;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
