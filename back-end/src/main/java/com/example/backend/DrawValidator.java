package com.example.backend;

import java.util.List;

public class DrawValidator {

    // Vérifie si le tirage respecte toutes les règles.
    public boolean isValid(
        Participant participant1,
        Participant participant2,
        DrawRequest request
    ) {

        if (isForbidden(participant1, participant2, request.getForbiddenAssociations())) {
            return false;
        }

        return true;
    }

    // Vérifie s'il existe une interdiction entre deux participants.
    private boolean isForbidden(
      Participant a,
      Participant b,
      List<ForbiddenAssociation> rules
   ) {

    for (ForbiddenAssociation rule : rules) {

        if (
            (rule.getFirstParticipantId() == a.getId()
            &&
            rule.getSecondParticipantId() == b.getId())

            ||

            (rule.getFirstParticipantId() == b.getId()
            &&
            rule.getSecondParticipantId() == a.getId())
        ) {
            return true;
        }
    }

    return false;
  }
}
