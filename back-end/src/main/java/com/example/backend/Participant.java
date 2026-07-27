package com.example.backend;

public class Participant {

    private int id;
    private String name;
    private Integer hatId;

    public Participant(int id, String name, Integer hatId) {
        this.id = id;
        this.name = name;
        this.hatId = hatId;
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

    public Integer getHatId() {
        return hatId;
    }

    public void setHatId(Integer hatId) {
        this.hatId = hatId;
    }

    // Remplace une méthode qui existe déjà dans une classe parent.
    @Override
    public boolean equals(Object obj) {

    // Vérifie si c'est exactement le même objet
    if (this == obj) {
        return true;
    }

    // Vérifie que l'objet est bien un Participant
    if (!(obj instanceof Participant)) {
      return false;
    }

    Participant other = (Participant) obj;
    return this.id == other.id;
  }

    @Override
    // Permet d'identifier un participant avec son id dans les collections Java comme HashSet ou HashMap.
    public int hashCode() {
      return Integer.hashCode(id);
  }
}
