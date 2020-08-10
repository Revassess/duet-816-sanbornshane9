package com.revature.model;

public enum Role {
    PREMIUM_USER,
    BASIC_USER;

    private final String roleName;

    Role(int id) {
        switch(id){
            case 1:
                roleName = "PREMIUM_USER";
                break;
            case 2:
                roleName = "REGULAR_USER";
                break;
            default:
                roleName = null;
        }
    }

    Role(){
        roleName = null;
    }


    public String toString(){
        return this.roleName;
    }

    public int getID(){
        if(roleName.equals("PREMIUM_USER")){
            return 1;
        }
        else{
            return 2;
        }
    }
}