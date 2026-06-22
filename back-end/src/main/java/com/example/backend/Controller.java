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

    @GetMapping("/datadraw")
    public List<DrawData> getAlldatadraw() {
        return datadrawList;
    }

    @PostMapping("/datadraw")
    public String addDatadraw(@RequestBody DrawRequest request) {

    for (String participant : request.getParticipants()) {
        System.out.println("Participant : " + participant);
    }

    return "Liste reçue avec succès";
   }

    @PutMapping("/datadraw/{id}")
    public String updateDatadraw(@PathVariable int id, @RequestBody DrawData updatedDataDraw) {
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
