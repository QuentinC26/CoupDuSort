package com.example.backend;

import java.util.List;

public class DrawValidator {

    // Vérifie si un participant peut être tiré.
    public boolean isValid(
        Participant participant,
        List<Participant> alreadyDrawn,
        DrawRequest request
    ) {

        // Vérifie si le participant a déjà été tiré
        if (alreadyDrawn.contains(participant)) {
            return false;
        }
        
        // Vérifie les interdictions
        if (hasForbiddenAssociation(
          participant,
          alreadyDrawn,
          request.getForbiddenAssociations()
        )) {
          return false;
        }
        return true;
    }

    // Vérifie si le participant a une interdiction avec un participant déjà tiré
    private boolean hasForbiddenAssociation(
      Participant participant,
      List<Participant> alreadyDrawn,
      List<ForbiddenAssociation> rules
    ) {

    if (rules == null) {
        return false;
    }

    // Vérifie si le participant qu'on veut tirer a une interdiction avec un participant qui est déjà sorti.
    for (Participant drawnParticipant : alreadyDrawn) {
        for (ForbiddenAssociation rule : rules) {
            if (
                (rule.getFirstParticipantId() == participant.getId()
                &&
                rule.getSecondParticipantId() == drawnParticipant.getId())
                ||
                (rule.getFirstParticipantId() == drawnParticipant.getId()
                &&
                rule.getSecondParticipantId() == participant.getId())
            ) {
                return true;
            }
        }
    }
    return false;
  }
}
