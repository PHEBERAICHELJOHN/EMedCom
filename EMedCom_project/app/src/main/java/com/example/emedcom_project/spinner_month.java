package com.example.emedcom_project;

public class spinner_month {

    private Integer id;
    private String name;

    public spinner_month(int id, String name) {
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
        if(obj instanceof spinner_month){
            spinner_month c = (spinner_month) obj;
            if(c.getName().equals(name) && c.getId()==id ) return true;
        }

        return false;
    }

}
