package com.moviesdashboard.model;

import javax.persistence.*;

import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imdb_id", unique = true, nullable = false)
    private String imdbId;

    private String title;
    private String year;
    private String rated;
    private Date released;
    private String runtime;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String posterUrl;
    private Integer metascore;
    private Double imdbRating;
    private String imdbVotes;
    private String type;
    private Date dvdRelease;
    private String boxOffice;
    private String production;
    private String website;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Rating> ratings = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "movie_actors",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "movie_genres",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres = new ArrayList<>();

    // Getters and setters
}
