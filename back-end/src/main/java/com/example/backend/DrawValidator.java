package com.example.backend;

import java.util.List;

public class DrawValidator {

    // Vérifie si un participant peut être tiré.
    public boolean isValid(
        Participant participant,
        List<Participant> alreadyDrawn,
        int currentHat,
        DrawRequest request
    ) {

        // Vérifie si le participant a déjà été tiré
        if (alreadyDrawn.contains(participant)) {
            return false;
        }
        
        if (request.isUseHatSystem()) {
          // Vérifie les interdictions quand les chapeaux sont activés
          if (hasForbiddenAssociationInHat(
            participant,
            alreadyDrawn,
            currentHat,
            request.getForbiddenAssociations()
          )) {
            return false;
          }
        } else {
          // Vérifie les interdictions quand les chapeaux sont désactivés
          if (hasForbiddenAssociation(
            participant,
            alreadyDrawn,
            request.getForbiddenAssociations()
          )) {
            return false;
          }
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
    if (alreadyDrawn.isEmpty()) {
      return false;
    }
    Participant lastDrawn = alreadyDrawn.get(alreadyDrawn.size() - 1);

    for (ForbiddenAssociation rule : rules) {
        if ((rule.getFirstParticipantId() == participant.getId() && rule.getSecondParticipantId() == lastDrawn.getId())
            ||
            (rule.getFirstParticipantId() == lastDrawn.getId() && rule.getSecondParticipantId() == participant.getId())
        ) {
            return true;
        }
    }
    return false;
  }

    // Vérifie si le participant a une interdiction avec un participant déjà tiré quand les chapeaux sont activés
    private boolean hasForbiddenAssociationInHat(
      Participant participant,
      List<Participant> alreadyDrawn,
      int currentHat,
      List<ForbiddenAssociation> rules
    ) {

    if (rules == null) {
        return false;
    }

    for (Participant drawnParticipant : alreadyDrawn) {
        // On ignore les participants des autres chapeaux
        if (drawnParticipant.getHatId() == null || drawnParticipant.getHatId().intValue() != currentHat) {
            continue;
        }
        for (ForbiddenAssociation rule : rules) {
            if (
                (rule.getFirstParticipantId() == participant.getId()
                    && rule.getSecondParticipantId() == drawnParticipant.getId())
                ||
                (rule.getFirstParticipantId() == drawnParticipant.getId()
                    && rule.getSecondParticipantId() == participant.getId())
            ) {
                return true;
            }
        }
    }
    return false;
  }
}
