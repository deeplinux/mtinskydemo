package com.mybatisdemo.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: lu
 * Date: 17-2-6
 * Time: 上午10:09
 * To change this template use File | Settings | File Templates.
 */
public class BaseFile {
    private int id;
    private String sid;    //文件唯一标识
    private String name;   //文件名
    private String importTime;      //上传时间
    private String endCaptureTime;  //文件结束拍摄时间
    private String startCaptureTime;        //文件开始拍摄时间
    private int type;      //媒体类型，1：视频，2：语音，3：图像，0：其他
    private long size;     //媒体大小，单位BYTE
    private int quality;   //媒体质量 :1 高清，2普清
    private int duration;  //媒体播放时长，单位秒，图片与其它非媒体文件为0
    private String path;   //源媒体文件下载路径
    private String playPath;   //源文件播放路径
    private String thumbnail;  //媒体缩略图地址
    private int status;        //文件记录状态，0：正常，1：已删除

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImportTime() {
        return importTime;
    }

    public void setImportTime(String importTime) {
        this.importTime = importTime;
    }

    public String getEndCaptureTime() {
        return endCaptureTime;
    }

    public void setEndCaptureTime(String endCaptureTime) {
        this.endCaptureTime = endCaptureTime;
    }

    public String getStartCaptureTime() {
        return startCaptureTime;
    }

    public void setStartCaptureTime(String startCaptureTime) {
        this.startCaptureTime = startCaptureTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPlayPath() {
        return playPath;
    }

    public void setPlayPath(String playPath) {
        this.playPath = playPath;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
