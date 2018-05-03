package cn.windy.kernel.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "windy_notice")
public class Notice extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1697210407364223442L;
	private String title;
    private Integer type;
    private String content;
    private String noticePersonnel;

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "notice_personnel")
    public String getNoticePersonnel() {
        return noticePersonnel;
    }

    public void setNoticePersonnel(String noticePersonnel) {
        this.noticePersonnel = noticePersonnel;
    }


}
