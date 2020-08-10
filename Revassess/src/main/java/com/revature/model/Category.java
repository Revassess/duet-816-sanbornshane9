package com.revature.model;

public enum Category {
    math,
    science,
    english;

    private final String categoryName;

    private Category(int id) {
        switch(id){
            case 1:
                categoryName = "math";
                break;
            case 2:
                categoryName = "science";
                break;
            case 3:
                categoryName = "english";
                break;
            default:
                categoryName = null;
        }
    }


    Category() {
        categoryName = null;
    }

    public String toString(){
        return this.categoryName;
    }

    public int getID(){
        if(categoryName.equals("math")){
            return 1;
        }
        else if(categoryName.equals("science")){
            return 2;
        }
        else{
            return 3;
        }
    }
}