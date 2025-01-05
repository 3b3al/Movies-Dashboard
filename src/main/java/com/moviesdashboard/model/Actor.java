package com.moviesdashboard.model;

import javax.persistence.*;

import lombok.Data;

import java.util.*;

@Data
@Entity
@Table(name = "actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY)
    private List<Movie> movies = new ArrayList<>();

    // Getters and setters
}
