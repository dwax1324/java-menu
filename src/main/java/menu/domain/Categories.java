package menu.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Categories {
    private final List<Category> categoryList = new ArrayList<>();

    public void add(Category category){
        categoryList.add(category);
    }
    public int size(){
        return categoryList.size();
    }
    public Category get(int index){
        return categoryList.get(index);
    }
    public int getCount(Category category){
        return Collections.frequency(categoryList,category);
    }

}
