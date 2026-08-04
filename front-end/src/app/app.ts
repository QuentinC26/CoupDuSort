import { Component } from '@angular/core';
import { Router, RouterOutlet, RouterLink } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App {
  menuOuvert = false;

  constructor(private router: Router) {}

  toggleMenu() {
    this.menuOuvert = !this.menuOuvert;
  }

  getTheme(): string {
    switch(this.router.url) {
      case '/casino':
        return 'theme-casino';
      case '/noel':
        return 'theme-noel';
      case '/halloween':
        return 'theme-halloween';
      case '/sportif':
        return 'theme-sportif';
      default:
        return 'theme-classique';
    }
  }
}
