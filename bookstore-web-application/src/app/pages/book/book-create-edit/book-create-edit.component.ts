import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Author } from 'src/app/models/author';
import { Book } from 'src/app/models/book';
import { Genre } from 'src/app/models/genre';
import { Image } from 'src/app/models/image';
import { Publisher } from 'src/app/models/publisher';
import { HttpService } from 'src/app/services/http.service';
import { PictureToBase64ConverterService } from 'src/app/services/picture-to-base-64-converter.service';
import { Constants } from 'src/environment/constants';
import { Environment } from 'src/environment/environment';

@Component({
  selector: 'app-book-create-edit',
  templateUrl: './book-create-edit.component.html',
  styleUrl: './book-create-edit.component.css'
})
export class BookCreateEditComponent implements OnInit {

  languages = Constants.languages;

  genres: Genre[] = [];
  publishers: Publisher[] = [];
  authors: Author[] = [];

  bookIsbn: string | undefined;
  book: Book = <Book>{};

  constructor(private httpService: HttpService, private converter: PictureToBase64ConverterService, private router: Router, private route: ActivatedRoute) {
    this.bookIsbn = this.route.snapshot.params['isbn'];
  }

  ngOnInit(): void {
    this.loadGenres();
    this.loadPublishers();
    this.loadAuthors();

    if (this.bookIsbn) {
      this.httpService.getBookByIsbn(this.bookIsbn).subscribe((response: Book) => this.book = response);
    }
  }

  loadGenres() {
    this.httpService.getAllData(Environment.GENRE).subscribe((resp: Genre[]) => this.genres = resp);
  }

  loadPublishers() {
    this.httpService.getAllData(Environment.PUBLISHER).subscribe((resp: Publisher[]) => this.publishers = resp);
  }

  loadAuthors() {
    this.httpService.getAllData(Environment.AUTHOR).subscribe((resp: Author[]) => this.authors = resp);
  }

  async addDescriptionPicture(el: any) {
    let imageContent = await this.converter.convertPictureToString(el);
    let image: Image = <Image>{};
    image.content = imageContent;
    this.book.image = image;
  }

  submitBook() {
    if (this.book.isbn) {
      this.book.isbn = this.book.isbn.replace(/-/g, "");
    };

    this.httpService.createData(Environment.BOOK, this.book).subscribe(() =>
      this.router.navigate(['/books'])
    );
  }
}
