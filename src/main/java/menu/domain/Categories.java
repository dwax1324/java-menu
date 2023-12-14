package menu.domain;

import java.util.List;

public class Categories {
    private final List<Category> categoryList;

    public Categories(List<Category> categoryList){
        this.categoryList = categoryList;
    }
    public Category get(int index){
        return categoryList.get(index);
    }

}
