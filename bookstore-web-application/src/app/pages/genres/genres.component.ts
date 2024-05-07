import { Component } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Genre } from 'src/app/models/genre';
import { HttpService } from 'src/app/services/http.service';
import { Environment } from 'src/environment/environment';

@Component({
  selector: 'app-genres',
  templateUrl: './genres.component.html',
  styleUrls: ['./genres.component.css'],
  providers: [MessageService, ConfirmationService]
})
export class GenresComponent {

  editing: boolean = false;
  dialogVisible: boolean = false;
  genres: any;
  newGenre: Genre = <Genre>{};

  clonedGenres: { [s: string]: Genre } = {};

  constructor(private httpService: HttpService, private messageService: MessageService, private confirmationService: ConfirmationService) { }

  ngOnInit(): void {
    this.loadAllGenres();
  }

  loadAllGenres() {
    this.httpService.getAllData(Environment.GENRE).subscribe((response: Genre[]) => this.genres = response);
  }

  onRowEditSave(genre: Genre) {
    this.httpService.updateData(Environment.GENRE, genre).subscribe((response: any) => {
      this.loadAllGenres();
      this.messageService.add({ severity: 'success', detail: 'Genre succsessfully updated' });
    })
  }

  onCreateNewGenreClick() {
    this.httpService.createData(Environment.GENRE, this.newGenre).subscribe((response: any) => {
      this.newGenre = <Genre>{};
      this.dialogVisible = false;
      this.loadAllGenres();
      this.messageService.add({ severity: 'success', detail: 'Genre successfully created' });
    })
  }

  showDeleteConfirmDialog(event: Event, genre: Genre) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: `Are you sure you want to delete genre: <b>${genre.name}</b>?`,
      header: 'Confirmation',
      icon: 'pi pi-exclamation-triangle',
      acceptLabel: 'Yes',
      acceptIcon: "pi pi-check mr-2",
      rejectLabel: 'No',
      rejectIcon: "pi pi-times mr-2",
      rejectButtonStyleClass: "p-button-text bg-primary",
      accept: () => {
        this.httpService.deleteDataById(Environment.GENRE, genre.id).subscribe((response: any) => {
          this.loadAllGenres();
          this.messageService.add({ severity: 'success', detail: 'Genre successfully deleted' });
        })
      }
    });
  }
}
