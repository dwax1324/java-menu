package menu.domain.category;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.coach.Coach;

public class Categories {
    private final List<Category> categoryList = new ArrayList<>();

    public void add(Category category) {
        categoryList.add(category);
    }

    public int size() {
        return categoryList.size();
    }

    public Category get(int index) {
        return categoryList.get(index);
    }

    public int getCount(Category category) {
        return Collections.frequency(categoryList, category);
    }

    public List<String> getCategoryNames() {
        return categoryList.stream().map(Category::getName).collect(Collectors.toList());
    }


    // 다섯개의 메뉴를 반환한다
    public List<String> getFiveMenu(Coach coach) {
        List<String> candidates = new ArrayList<>();
        int index = 0;
        while (candidates.size() < 5) {
            List<String> menus = categoryList.get(index).getMenus();
//            System.out.println(categoryList.get(index).getName() + " " + menus);
            String candidate = Randoms.shuffle(menus).get(0);
            if (candidates.contains(candidate)) { // duplicated
                continue;
            }
            if (coach.getMenus().contains(candidate)) { // cant eat
                continue;
            }
            index++;
            candidates.add(candidate);
        }
        return candidates;
    }
}