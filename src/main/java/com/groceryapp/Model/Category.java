package com.groceryapp.Model;

import lombok.Getter;

@Getter
public enum Category {
    FRUIT("FRUIT"),
    SOFT_DRINK("SOFT_DRINK"),
    PERSONAL_CARE("PERSONAL_CARE"),
    SNACK("SNACK"),
    CONDIMENT("CONDIMENT");

    private final String categoryType;

    Category(String categoryType) {
        this.categoryType = categoryType;
    }

    public static Category getCategoryType(String categoryType) {
        return Category.valueOf(categoryType.toUpperCase());
    }
}
