package com.example.backend;

import java.util.List;

// Classe qui reçoit les données nécessaires pour faire le tirage.
public class DrawRequest {

    private List<Participant> participants;
    private List<ForbiddenAssociation> forbiddenAssociations;
    private int numberOfHats;

    public List<Participant> getParticipants()  {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<ForbiddenAssociation> getForbiddenAssociations() {
        return forbiddenAssociations;
    }

    public void setForbiddenAssociations(List<ForbiddenAssociation> forbiddenAssociations) {
        this.forbiddenAssociations = forbiddenAssociations;
    }

     public int getNumberOfHats() {
        return numberOfHats;
    }

    public void setNumberOfHats(int numberOfHats) {
        this.numberOfHats = numberOfHats;
    }
}
