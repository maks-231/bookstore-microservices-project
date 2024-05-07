import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ConfirmationService } from 'primeng/api';
import { Book } from 'src/app/models/book';
import { HttpService } from 'src/app/services/http.service';
import { Environment } from 'src/environment/environment';

@Component({
  selector: 'app-book-view',
  templateUrl: './book-view.component.html',
  styleUrl: './book-view.component.css',
  providers: [ConfirmationService]
})
export class BookViewComponent implements OnInit {

  bookIsbn: number;
  book: Book = <Book>{};

  constructor(
    private httpService: HttpService,
    private route: ActivatedRoute,
    private confirmationService: ConfirmationService,
    private router: Router
  ) {
    this.bookIsbn = route.snapshot.params['isbn'];
  }

  ngOnInit(): void {
    this.loadBook();
  }

  loadBook() {
    this.httpService.getBookByIsbn(this.bookIsbn).subscribe((resp: Book) => this.book = resp);
  }

  deleteBook(event: Event) {
    console.log(this.confirmationService);

    if (confirm("Are you sure?")) {
      this.httpService.deleteDataById(Environment.BOOK, this.book.isbn).subscribe((response: any) => {})
    }

    // this.confirmationService.confirm({
    //   target: event.target as EventTarget,
    //   message: `Are you sure you want to delete book: <b>${this.book.title}</b>?`,
    //   header: 'Confirmation',
    //   icon: 'pi pi-exclamation-triangle',
    //   acceptLabel: 'Yes',
    //   acceptIcon: "pi pi-check mr-2",
    //   rejectLabel: 'No',
    //   rejectIcon: "pi pi-times mr-2",
    //   rejectButtonStyleClass: "p-button-text bg-primary",
    //   accept: () => {
    //     this.httpService.deleteDataById(Environment.BOOK, this.book.isbn).subscribe((response: any) => {
    //     })
    //   }
    // });
  }
}
