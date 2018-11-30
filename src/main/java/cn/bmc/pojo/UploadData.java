package cn.bmc.pojo;

import java.util.Date;

public class UploadData {
    private Integer g_id;  //商品id号
    private Double g_price; //商品表格价格
    private Integer s_id;   //店铺id号
    private Date uptime;    //上传上传时间

    public UploadData() {
        super();
    }

    @Override
    public String toString() {
        return "UploadData{" +
                "g_id=" + g_id +
                ", g_price=" + g_price +
                ", s_id=" + s_id +
                ", uptime=" + uptime +
                '}';
    }

    public UploadData(Integer g_id, Double g_price, Integer s_id, Date uptime) {
        this.g_id = g_id;
        this.g_price = g_price;
        this.s_id = s_id;
        this.uptime = uptime;
    }

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public Double getG_price() {
        return g_price;
    }

    public void setG_price(Double g_price) {
        this.g_price = g_price;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }
}
