package com.example.emedcom_project;


public class spinner_source_districts {

    private Integer id;
    private String name;

    public spinner_source_districts(int id, String name) {
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
        if(obj instanceof spinner_source_districts){
            spinner_source_districts c = (spinner_source_districts) obj;
            if(c.getName().equals(name) && c.getId()==id ) return true;
        }

        return false;
    }

}

