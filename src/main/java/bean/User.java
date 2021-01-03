package bean;

import java.util.Date;

// 用户
public class User {
    private Integer userId;
    private String userName;
    private String email;
    private String password;
    // 创建时间
    private Date createdAt;
    // 密码修改时间
    private Date modifiedAt;
    // 听歌时长,以秒为单位
    private Integer listenTime;
    //是否为vip，是为true，否为false
    private boolean isVip;

    public User() {
    }

    public User(Integer userId, String userName, String email, String password, Date createdAt, Date modifiedAt, Integer listenTime, boolean isVip) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.listenTime = listenTime;
        this.isVip = isVip;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Integer getListenTime() {
        return listenTime;
    }

    public void setListenTime(Integer listenTime) {
        this.listenTime = listenTime;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }
}
