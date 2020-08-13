package com.lambdaschool.zoos.models;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ZooAnimalId implements Serializable {

    /** Fields*/
    private long animal;

    private long zoo;

    /** Constructor*/
    public ZooAnimalId() {
    }

    /** Getters and Setters*/
    public long getAnimal() {
        return animal;
    }

    public void setAnimal(long animal) {
        this.animal = animal;
    }

    public long getZoo() {
        return zoo;
    }

    public void setZoo(long zoo) {
        this.zoo = zoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ZooAnimalId that = (ZooAnimalId) o;
        return this.getAnimal() == that.getAnimal() &&
            this.getZoo() == that.getZoo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getAnimal(),
            this.getZoo());
    }
}
