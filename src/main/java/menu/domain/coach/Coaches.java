package menu.domain.coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.category.Category;

public class Coaches {
    private final List<Coach> coachList = new ArrayList<>();

    public void add(Coach coach) {
        coachList.add(coach);
    }

    public int size() {
        return coachList.size();
    }

    public Coach get(int index) {
        return coachList.get(index);
    }

    public int getCount(Category category) {
        return Collections.frequency(coachList, category);
    }

}
