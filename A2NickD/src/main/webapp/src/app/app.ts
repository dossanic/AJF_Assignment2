import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Feeds } from './feeds/feeds'

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Feeds],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  //protected readonly title = signal('webapp');
}
