package cn.windy.kernel.vo;

import cn.windy.kernel.model.Menu;
import cn.windy.kernel.model.RoleMenu;

public class MenuVo {

    private Menu menu;
    private RoleMenu roleMenu;

    public MenuVo() {
    }

    public MenuVo(Menu menu, RoleMenu roleMenu) {
        this.menu = menu;
        this.roleMenu = roleMenu;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public RoleMenu getRoleMenu() {
        return roleMenu;
    }

    public void setRoleMenu(RoleMenu roleMenu) {
        this.roleMenu = roleMenu;
    }
}
