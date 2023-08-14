package com.app.calculator.categories;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Categories {
    public ObservableList<String> observableList_Category = FXCollections.observableArrayList();
    public String nameCategory;
    public HashMap<String, Categories> subCategory = new HashMap<>();
    public HashMap<String, BigDecimal> coeficient = new HashMap<>();
    public Categories() {

    }
    public String getNameCategory() {
        return nameCategory;
    }

    public ObservableList<String> getObservableList_Category() {
        return observableList_Category;
    }

    public HashMap<String, Categories> getSubCategory() {
        return subCategory;
    }
    public ObservableList<String> getSubCategoryKeys() {
        Set<String> set = subCategory.keySet();
        List<String> keyList = new ArrayList<>(set);
        ObservableList<String> observableList = FXCollections.observableList(keyList);
        return observableList;
    }
}
