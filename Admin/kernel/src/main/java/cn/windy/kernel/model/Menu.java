package cn.windy.kernel.model;

import javax.persistence.*;

/**
 * 菜单
 */
@Entity
@Table(name = "windy_menu")
public class Menu extends BaseModel {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8998144796021341852L;
	private String name;
    private String code;
    private Long pid;
    private String url;
    private String icon;
    private String hasChildren;
    private String isExtern;
    private String flag;
    private String remark;
    private Long displayOrder;

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "pid")
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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
    @Column(name = "icon_")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Basic
    @Column(name = "has_children")
    public String getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(String hasChildren) {
        this.hasChildren = hasChildren;
    }

    @Basic
    @Column(name = "is_extern")
    public String getIsExtern() {
        return isExtern;
    }

    public void setIsExtern(String isExtern) {
        this.isExtern = isExtern;
    }

    @Basic
    @Column(name = "flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "display_order")
    public Long getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Long displayOrder) {
        this.displayOrder = displayOrder;
    }
}
