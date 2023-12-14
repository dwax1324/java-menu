package menu.domain.coach;

import java.util.List;

public class Coach {
    private String name;

    private List<String> menus;

    public Coach(String name, List<String> menus) {
        this.name = name;
        this.menus = menus;
    }

    public String getName() {
        return name;
    }

    public List<String> getMenus() {
        return menus;
    }

}
