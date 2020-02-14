package com.msg.group;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Person {

    public Person() {
    }

    public Person(Long id, String name, String surname, Date born, Date died, String species, String gender, String height, String eyeColor) {
        this.id = id;
        this.born = born;
        this.died = died;
        this.name = name;
        this.surname = surname;
        this.species = species;
        this.gender = gender;
        this.height = height;
        this.eyeColor = eyeColor;
    }

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private Date born;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy")
    private Date died;

    private String name;

    private String surname;

    private String species;

    private String gender;

    private String height;

    private String eyeColor;

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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", born=" + born +
                ", died=" + died +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", species='" + species + '\'' +
                ", gender='" + gender + '\'' +
                ", height='" + height + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                '}';
    }
}
