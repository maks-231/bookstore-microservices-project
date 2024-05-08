import { Injectable } from '@angular/core';
import { Genre } from '../models/genre';

const GENRES_KEY = 'genres';

@Injectable({
  providedIn: 'root'
})
export class StoreService {

  private genres: Genre[] = [];

  constructor() { }

  initializeGenres(genres: Genre[]) {
    let item = localStorage.getItem(GENRES_KEY);
    if (item) {
      this.genres = JSON.parse(item);
    } else {
      this.genres = genres;
      localStorage.setItem(GENRES_KEY, JSON.stringify(genres));
    }
  }

  getCategories() {
    return this.genres;
  }
}
