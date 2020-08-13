package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "zooanimals")
@IdClass(ZooAnimalId.class)
public class ZooAnimal implements Serializable {

    /** Id's*/
    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = "animals")
    @JoinColumn(name = "animalid")
    private Animal animal;

    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = "zoos")
    @JoinColumn(name = "zooid")
    private Zoo zoo;

    /** Constructor*/
    public ZooAnimal() {
    }

    /** Getters and Setters*/
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    /** Equals and HashCodes*/
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ZooAnimal that = (ZooAnimal) o;
        return ((this.getAnimal() == null) ? 0 : this.getAnimal().getAnimalid()) ==
                    ((that.getAnimal() == null ? 0 : that.getAnimal().getAnimalid())) &&
                        ((this.getZoo() == null) ? 0 : this.getZoo().getZooid()) ==
                            ((that.getZoo() == null ? 0 : that.getZoo().getZooid()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAnimal(),
            getZoo());
    }
}
