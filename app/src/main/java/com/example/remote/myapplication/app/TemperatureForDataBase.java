package com.example.remote.myapplication.app;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "temperature")
public class TemperatureForDataBase {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "city")
    private String city;

    @Property(nameInDb = "date")
    private long date;

    @Property(nameInDb = "temperature")
    private int temperature;

    @Property(nameInDb = "networkImgUrl")
    private String networkImgUrl;

    @Property(nameInDb = "localImgUrl")
    private String localImgUrl;

    @Generated(hash = 1401122378)
    public TemperatureForDataBase(Long id, String city, long date, int temperature,
            String networkImgUrl, String localImgUrl) {
        this.id = id;
        this.city = city;
        this.date = date;
        this.temperature = temperature;
        this.networkImgUrl = networkImgUrl;
        this.localImgUrl = localImgUrl;
    }

    @Generated(hash = 424668541)
    public TemperatureForDataBase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getNetworkImgUrl() {
        return networkImgUrl;
    }

    public void setNetworkImgUrl(String networkImgUrl) {
        this.networkImgUrl = networkImgUrl;
    }

    public String getLocalImgUrl() {
        return localImgUrl;
    }

    public void setLocalImgUrl(String localImgUrl) {
        this.localImgUrl = localImgUrl;
    }
}
