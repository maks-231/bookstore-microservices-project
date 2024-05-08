import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookListComponent } from './pages/book/book-list/book-list.component';
import { GenresComponent } from './pages/genres/genres.component';
import { PublishersComponent } from './pages/publishers/publishers.component';
import { BookCreateEditComponent } from './pages/book/book-create-edit/book-create-edit.component';
import { AuthorsComponent } from './pages/authors/authors.component';
import { BookViewComponent } from './pages/book/book-view/book-view.component';

const routes: Routes = [
  { path: '', component: BookCreateEditComponent },
  { path: 'books', component: BookListComponent },
  { path: 'book/create', component: BookCreateEditComponent },
  { path: 'book/edit/:isbn', component: BookCreateEditComponent },
  { path: 'book/:isbn', component: BookViewComponent },
  { path: 'genres', component: GenresComponent },
  { path: 'publishers', component: PublishersComponent },
  { path: 'authors', component: AuthorsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
