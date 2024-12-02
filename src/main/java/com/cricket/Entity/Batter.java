package com.cricket.Entity;


import javax.persistence.*;

@Entity
@Table(name = "batters")
public class Batter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @Column(name = "matches")
    private int matches;

    @Column(name = "runs")
    private int runs;

    @Column(name = "highest_score")
    private int highestScore;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    public int getMatches() { return matches; }
    public void setMatches(int matches) { this.matches = matches; }
    public int getRuns() { return runs; }
    public void setRuns(int runs) { this.runs = runs; }
    public int getHighestScore() { return highestScore; }
    public void setHighestScore(int highestScore) { this.highestScore = highestScore; }
}
