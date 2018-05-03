package cn.windy.kernel;


import cn.windy.kernel.model.User;

/**
 * 存贮于redis中的默认配置信息 <br/>
 * 如果为空，则取类中默认值
 */
public class UserConfig {

    /**
     * 默认分页大小，可以自我调整，会将这人值存贮在redis中
     */
    private int pageSize = 10;

    private User user;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
