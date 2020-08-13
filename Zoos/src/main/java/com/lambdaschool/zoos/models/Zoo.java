package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zoo")
public class Zoo {

    /** Fields*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    @Column(nullable = false, unique = true)
    private String zooname;

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo")
    private Set<ZooAnimal> animals = new HashSet<>();

    /** Constructors */
    public Zoo() {
    }

    public Zoo(String zooname) {
        this.zooname = zooname;
    }

    /** Getter and Setter */
    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public Set<ZooAnimal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<ZooAnimal> animals) {
        this.animals = animals;
    }
}
