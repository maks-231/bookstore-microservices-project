import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/models/book';
import { Genre } from 'src/app/models/genre';
import { HttpService } from 'src/app/services/http.service';
import { Environment } from 'src/environment/environment';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[] = [];
  genres: Genre[] = [];
  selectedGenre: Genre = {};

  constructor(private httpService: HttpService) { }

  ngOnInit(): void {
    this.loadAllGenres();
    this.loadAllBooks();
  }

  loadAllGenres() {
    this.httpService.getAllData(Environment.GENRE).subscribe((response: Genre[]) => this.genres = response);
  }

  loadAllBooks() {
    this.httpService.getAllData(Environment.BOOK).subscribe((response: Book[]) => this.books = response);
  }

  onGenreChangeEvent(event: any) {
    this.httpService.getBooksByGenre(event.value.id).subscribe((response: Book[]) => this.books = response);
  }
}
