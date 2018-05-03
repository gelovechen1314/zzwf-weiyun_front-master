package cn.windy.module.wechat.model;

import cn.windy.kernel.model.BaseModel;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wechat_menu")
public class WeChatMenu extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7712568237272166667L;
	private String name;
    private String type;
    private String btnKey;
    private String url;
    private String appId;
    private String pagepath;
    private Long pid;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "btn_key")
    public String getBtnKey() {
        return btnKey;
    }

    public void setBtnKey(String btnKey) {
        this.btnKey = btnKey;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "app_id")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "pagepath")
    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    @Basic
    @Column(name = "pid")
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

}
