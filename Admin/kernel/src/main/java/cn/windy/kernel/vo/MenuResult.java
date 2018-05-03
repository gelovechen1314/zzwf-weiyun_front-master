package cn.windy.kernel.vo;

import cn.windy.kernel.model.Menu;
import org.springframework.data.domain.Page;

public class MenuResult extends Result {

    private Page<Menu> page;
    private String menuJson;

    public Page<Menu> getPage() {
        return page;
    }

    public void setPage(Page<Menu> page) {
        this.page = page;
    }

    public String getMenuJson() {
        return menuJson;
    }

    public void setMenuJson(String menuJson) {
        this.menuJson = menuJson;
    }
}
