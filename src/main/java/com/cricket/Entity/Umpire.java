package com.cricket.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import jakarta.persistence.*;

@Entity
@Table(name = "umpires")
public class Umpire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "matches_officiated")
    private int matchesOfficiated;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getMatchesOfficiated() { return matchesOfficiated; }
    public void setMatchesOfficiated(int matchesOfficiated) { this.matchesOfficiated = matchesOfficiated; }
}
