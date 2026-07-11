package com.example.backend;

public class Participant {

    private int id;
    private String name;

    public Participant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Constructeur vide nécessaire pour que Spring Boot (via Jackson) puisse créer automatiquement 
    // un objet Participant à partir des données JSON envoyées par le front-end.
    public Participant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}