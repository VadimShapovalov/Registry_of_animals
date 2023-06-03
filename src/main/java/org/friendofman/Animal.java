package org.friendofman;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

public abstract class Animal implements Serializable {
    private int id = 0;
    private String typeAnimal;
    private String kindOfAnimal;
    private String name;
    private LocalDate dateOfBirth;
    private Set<Comma> commaSet;

    //private static final long serialVersionUID = 1L;
    protected Animal() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getKindOfAnimal() {
        return kindOfAnimal;
    }

    public void setKindOfAnimal(String kindOfAnimal) {
        this.kindOfAnimal = kindOfAnimal;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Set<Comma> getCommaSet() {
        return commaSet;
    }
    public void setCommaSet(Set<Comma> commaSet) {
        this.commaSet = commaSet;
    }


    @Override
    public String toString() {
        return String.format("%d %s %s %s", id, name, dateOfBirth.toString(), getCommaSet().toString());
    }
}

