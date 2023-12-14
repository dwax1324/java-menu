package menu.domain.coach;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.category.Category;

public class Coaches {
    private final List<Category> coachList = new ArrayList<>();

    public void add(Category category){
        coachList.add(category);
    }
    public int size(){
        return coachList.size();
    }
    public Category get(int index){
        return coachList.get(index);
    }
    public int getCount(Category category){
        return Collections.frequency(coachList,category);
    }

}
