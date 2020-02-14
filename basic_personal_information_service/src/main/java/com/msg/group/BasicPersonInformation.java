package com.msg.group;

public class BasicPersonInformation {

    public BasicPersonInformation() { }

    public BasicPersonInformation(Long id, String name, String surname, String species, String searchString, String message) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.species = species;
        this.searchString = searchString;
        this.message = message;
    }

    private Long id;

    private String name;

    private String surname;

    private String species;

    private String searchString;

    private String message;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BasicPersonInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", species='" + species + '\'' +
                ", searchString='" + searchString + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
