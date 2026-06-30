import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { bootstrapApplication } from '@angular/platform-browser';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App{

  newParticipants = '';
  participants: string[] = [];
  addSucess = '';
  resultat = '';

  constructor(private http: HttpClient) {}

  creerListe() {
    this.participants = this.newParticipants
      .split('\n')
      // trim() enlève les espaces au début et à la fin (exemple : " bob " devient "bob")
      .map(p => p.trim())
      .filter(p => p.length > 0);
      
      this.faireTirage();
      this.addSucess = `${this.participants.length} participants ajoutés !`;
  }

  faireTirage() {
    this.http.post(
    'http://localhost:8080/api/datadraw',
    {
      participants: this.participants
    },
    {
      // Empêche Angular d'essayer de convertir la réponse en objet JSON
      responseType: 'text'
    }
  ).subscribe(result => {
    this.resultat = result;
  });
}
}

bootstrapApplication(App);