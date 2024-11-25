package com.cricket.Entity;

//import jakarta.persistence.*;

import javax.persistence.*;

@Entity
@Table(name = "match_records")
public class MatchRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "team1")
    private String team1;

    @Column(name = "team2")
    private String team2;

    @Column(name = "winner")
    private String winner;

    @ManyToOne
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTeam1() { return team1; }
    public void setTeam1(String team1) { this.team1 = team1; }
    public String getTeam2() { return team2; }
    public void setTeam2(String team2) { this.team2 = team2; }
    public String getWinner() { return winner; }
    public void setWinner(String winner) { this.winner = winner; }
    public Venue getVenue() { return venue; }
    public void setVenue(Venue venue) { this.venue = venue; }
}
