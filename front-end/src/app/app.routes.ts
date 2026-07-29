import { Routes } from '@angular/router';
import { Draw } from './draw';

export const routes: Routes = [
  {
    path: '',
    component: Draw
  },
  {
    path: 'casino',
    component: Draw
  },
  {
    path: 'noel',
    component: Draw
  },
  {
    path: 'halloween',
    component: Draw
  },
  {
    path: 'sportif',
    component: Draw
  }
];
