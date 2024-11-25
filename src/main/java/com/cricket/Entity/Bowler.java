package com.cricket.Entity;

import javax.persistence.*;


//import jakarta.persistence.*;

@Entity
@Table(name = "bowlers")
public class Bowler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "wickets")
    private int wickets;

    @Column(name = "economy")
    private double economy;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public int getWickets() { return wickets; }
    public void setWickets(int wickets) { this.wickets = wickets; }
    public double getEconomy() { return economy; }
    public void setEconomy(double economy) { this.economy = economy; }
}
