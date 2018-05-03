package cn.windy.module.wechat.util.api.bean;

public class JsapiTicket {

    private String ticket;
    private int expiresIn;
    private long startTime;

    public JsapiTicket(String ticket, int expiresIn) {
        this.ticket = ticket;
        this.expiresIn = expiresIn;
        this.startTime = System.currentTimeMillis();
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
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
