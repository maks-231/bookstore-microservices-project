import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

//PRIMENG Modules
import { MenubarModule } from "primeng/menubar";
import { CardModule } from "primeng/card";
import { ButtonModule } from "primeng/button";
import { DialogModule } from "primeng/dialog";
import { ConfirmDialogModule } from "primeng/confirmdialog";
import { ToastModule } from "primeng/toast";
import { TableModule } from "primeng/table";
import { InputGroupModule } from "primeng/inputgroup";
import { InputNumberModule } from "primeng/inputnumber";
import { InputTextModule } from "primeng/inputtext";
import { DropdownModule } from "primeng/dropdown";
import { DividerModule } from "primeng/divider";
import { CalendarModule } from "primeng/calendar";
import { FloatLabelModule } from "primeng/floatlabel";
import { MultiSelectModule } from "primeng/multiselect";
import { InputMaskModule } from "primeng/inputmask";
import { EditorModule } from 'primeng/editor';
import { ListboxModule } from 'primeng/listbox';
import { PanelModule } from 'primeng/panel';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { GenresComponent } from './pages/genres/genres.component';
import { BookListComponent } from './pages/book/book-list/book-list.component';
import { PublishersComponent } from './pages/publishers/publishers.component';
import { BookCreateEditComponent } from './pages/book/book-create-edit/book-create-edit.component';
import { AuthorsComponent } from './pages/authors/authors.component';
import { BookViewComponent } from './pages/book/book-view/book-view.component';

@NgModule({
  declarations: [
    AppComponent,
    GenresComponent,
    BookListComponent,
    PublishersComponent,
    BookCreateEditComponent,
    BookViewComponent,
    AuthorsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,

    //PrimeNG
    MenubarModule,
    CardModule,
    ButtonModule,
    DialogModule,
    ConfirmDialogModule,
    ToastModule,
    TableModule,
    InputGroupModule,
    DropdownModule,
    InputTextModule,
    DividerModule,
    FloatLabelModule,
    InputNumberModule,
    CalendarModule,
    MultiSelectModule,
    InputMaskModule,
    EditorModule,
    ListboxModule,
    PanelModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
