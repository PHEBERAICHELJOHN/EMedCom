package com.example.emedcom_project;

public class spinner_condition_name {

    private Integer id;
    private String name;

    public spinner_condition_name(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //to display object as a string in spinner
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof spinner_condition_name){
            spinner_condition_name c = (spinner_condition_name) obj;
            if(c.getName().equals(name) && c.getId()==id ) return true;
        }

        return false;
    }

}

