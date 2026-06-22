package com.example.backend;

import java.util.List;

// Classe qui reçoit les données nécessaires pour faire le tirage.
public class DrawRequest {

    private List<String> participants;

    public List<String> getParticipants() {
        return participants;
    }

    public void setParticipants(List<String> participants) {
        this.participants = participants;
    }
}