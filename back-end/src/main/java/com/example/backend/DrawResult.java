package com.example.backend;

public class DrawResult {

    private Participant firstParticipant;
    private Participant secondParticipant;

    public DrawResult() {
    }

    public DrawResult(Participant firstParticipant, Participant secondParticipant) {
        this.firstParticipant = firstParticipant;
        this.secondParticipant = secondParticipant;
    }

    public Participant getFirstParticipant() {
        return firstParticipant;
    }

    public void setFirstParticipant(Participant firstParticipant) {
        this.firstParticipant = firstParticipant;
    }

    public Participant getSecondParticipant() {
        return secondParticipant;
    }

    public void setSecondParticipant(Participant secondParticipant) {
        this.secondParticipant = secondParticipant;
    }
}
