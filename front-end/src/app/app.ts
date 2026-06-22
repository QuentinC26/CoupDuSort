import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { bootstrapApplication } from '@angular/platform-browser';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App{

  newParticipants = '';
  participants: string[] = [];
  addSucess = '';

  constructor(private http: HttpClient) {}

  creerListe() {
    this.participants = this.newParticipants
      .split('\n')
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
    }
  ).subscribe(result => {
    console.log(result);
  });
}
}

bootstrapApplication(App);