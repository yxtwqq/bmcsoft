package cn.bmc.pojo;

import java.util.Date;

public class Uploads {
    private Integer up_id;//id
    private String up_path;//上传路径
    private Date up_time;//上传时间

    @Override
    public String toString() {
        return "Uploads{" +
                "up_id=" + up_id +
                ", up_path='" + up_path + '\'' +
                ", up_time=" + up_time +
                '}';
    }

    public Uploads() {
        super();
    }

    public Uploads(Integer up_id, String up_path, Date up_time) {
        this.up_id = up_id;
        this.up_path = up_path;
        this.up_time = up_time;
    }

    public Integer getUp_id() {
        return up_id;
    }

    public void setUp_id(Integer up_id) {
        this.up_id = up_id;
    }

    public String getUp_path() {
        return up_path;
    }

    public void setUp_path(String up_path) {
        this.up_path = up_path;
    }

    public Date getUp_time() {
        return up_time;
    }

    public void setUp_time(Date up_time) {
        this.up_time = up_time;
    }
}
