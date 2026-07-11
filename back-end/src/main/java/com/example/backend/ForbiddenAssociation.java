package com.example.backend;

public class ForbiddenAssociation {

    // Le premier participant concerné par l'interdiction et le deuxième participant concerné par l'interdiction
    private int firstParticipantId;
    private int secondParticipantId;

    // Constructeur vide nécessaire pour que Spring Boot (via Jackson) puisse créer automatiquement 
    // un objet Participant à partir des données JSON envoyées par le front-end.
    public ForbiddenAssociation() {
    }

    public ForbiddenAssociation(int firstParticipantId, int secondParticipantId) {
        this.firstParticipantId = firstParticipantId;
        this.secondParticipantId = secondParticipantId;
    }

    public int getFirstParticipantId() {
        return firstParticipantId;
    }

    public void setFirstParticipantId(int firstParticipantId) {
        this.firstParticipantId = firstParticipantId;
    }

    public int getSecondParticipantId() {
        return secondParticipantId;
    }

    public void setSecondParticipantId(int secondParticipantId) {
        this.secondParticipantId = secondParticipantId;
    }
}