package com.example.backend;

public class DrawData {

  // Valeurs des données partagés par l'utilisateur
  private int id;
  private String name;

  // Constructeur
  public DrawData(int id, String name) {
    this.id = id;
    this.name = name;
  }

  // Getters et Setters qui permettent de lire et modifier les données privées
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
