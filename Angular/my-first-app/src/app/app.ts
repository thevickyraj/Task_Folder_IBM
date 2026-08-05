import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  template: `
    <h1>My First Angular App</h1>

    <router-outlet></router-outlet>
  `,
  styleUrl: './app.css'
})
export class App {
}