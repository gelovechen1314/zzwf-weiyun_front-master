package cn.windy.module.wechat.util.api.bean;

public class AccessToken {
    private String token;
    private int expiresIn;
    private long startTime;

    public AccessToken(String token, int expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
        this.startTime = System.currentTimeMillis();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public boolean isExpired(){
        long interval = System.currentTimeMillis() - startTime;
        if(interval>=(expiresIn-100)*1000){
            return true;
        }
        return false;
    }
}
