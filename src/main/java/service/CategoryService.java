package service;

import models.Category;

import java.util.ArrayList;

public class CategoryService {
    public ArrayList<Category> categories = new ArrayList<>();

    public CategoryService() {
        categories.add(new Category(1,"laptop"));
        categories.add(new Category(2,"telephone"));
    }

    public Category finbyid(int id){
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id){
                return categories.get(i);
            }
        }
        return null;
    }
}
