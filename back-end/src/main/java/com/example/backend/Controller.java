package com.example.backend;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

// Pour éviter les erreurs Cors
@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/api")
public class Controller {

    private List<DrawData> datadrawList = new ArrayList<>();
    // Création du validateur qui permettra de vérifier si un tirage respecte les règles définies par l'utilisateur.
    private DrawValidator drawValidator = new DrawValidator();
    // Stocke les participants déjà tirés pour garantir qu'un participant ne soit pas sélectionné plusieurs fois
    private List<Participant> alreadyDrawn = new ArrayList<>();
    
    private List<Participant> currentGroup = new ArrayList<>();
    // // Historique des participants tirés au sort
    private List<Participant> drawHistory = new ArrayList<>();
    private int currentHat = 1;

    @GetMapping("/datadraw")
    public List<DrawData> getAlldatadraw() {
        return datadrawList;
    }

    @PostMapping("/datadraw")
    public String addDatadraw(@RequestBody DrawRequest request) {
        List<Participant> participants = request.getParticipants();
        Participant resultat = makeDraw(
                participants,
                request
        );
        if (resultat == null) {
          return "Le tirage est terminé";
        }
        return "Résultat : " + resultat.getName();
    }

    private Participant makeDraw(
        List<Participant> participants,
        DrawRequest request
    ) {

    // Liste vide qui servira à stocker uniquement les participants autorisés.
    List<Participant> availableParticipants = new ArrayList<>();

    for (Participant participant : participants) {
        // Si les chapeaux sont activés, on ne prend que le chapeau actuel
        if (participant.getHatId() != null && participant.getHatId().intValue() != currentHat) {
            continue;
        }
        // Vérifie que le participant peut être tiré
        if (drawValidator.isValid(
                participant,
                alreadyDrawn,
                currentGroup,
                currentHat,
                request
        )) {
        availableParticipants.add(participant);
        }
    }
    // Vérifie si la liste des participants possibles est vide
    if (availableParticipants.isEmpty()) {
        return null;
    }

    int index = (int)(Math.random() * availableParticipants.size());
    Participant participant = availableParticipants.get(index);
    
    alreadyDrawn.add(participant);
    currentGroup.add(participant);
    drawHistory.add(participant);
    // Passe au chapeau suivant uniquement si les chapeaux existent
    if (participant.getHatId() != null) {
       currentHat++;
        if (currentHat > request.getNumberOfHats()) {
          currentHat = 1;
          // Permet de passer au groupe suivant
          currentGroup.clear();
      }
    }
    return participant;
   }

    @PostMapping("/datadraw/reset")
    public String resetDraw() {
      alreadyDrawn.clear();
      drawHistory.clear();
      currentHat = 1;
      return "Tirage réinitialisé";
    }

    @PutMapping("/datadraw/{id}")
    public String updateDatadraw(
            @PathVariable int id,
            @RequestBody DrawData updatedDataDraw) {

        for (DrawData datadraw : datadrawList) {
            if (datadraw.getId() == id) {
                datadraw.setName(updatedDataDraw.getName());
                return "Données mises à jour avec succès";
            }
        }
        return "Détail introuvable !";
    }

    @DeleteMapping("/datadraw/{id}")
    public String deleteDataDraw(@PathVariable int id) {
        datadrawList.removeIf(datadraw -> datadraw.getId() == id);
        return "Données supprimées avec succès";
    }
}
