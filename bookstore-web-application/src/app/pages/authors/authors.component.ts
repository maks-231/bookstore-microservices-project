import { Component } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Author } from 'src/app/models/author';
import { HttpService } from 'src/app/services/http.service';
import { Environment } from 'src/environment/environment';

@Component({
  selector: 'app-authors',
  templateUrl: './authors.component.html',
  styleUrl: './authors.component.css',
  providers: [MessageService, ConfirmationService]
})
export class AuthorsComponent {

  editing: boolean = false;
  dialogVisible: boolean = false;
  authors: Author[] = [];
  newAuthor: Author = <Author>{};

  clonedAuthors: { [s: string]: Author } = {};

  constructor(private httpService: HttpService, private messageService: MessageService, private confirmationService: ConfirmationService) { }

  ngOnInit(): void {
    this.loadAllAuthors();
  }

  loadAllAuthors() {
    this.httpService.getAllData(Environment.AUTHOR).subscribe((response: Author[]) => this.authors = response);
  }

  onRowEditSave(author: Author) {
    this.httpService.updateData(Environment.AUTHOR, author).subscribe((response: any) => {
      this.loadAllAuthors();
      this.messageService.add({ severity: 'success', detail: 'Author succsessfully updated' });
    })
  }

  onCreateNewAuthorClick() {
    this.httpService.createData(Environment.AUTHOR, this.newAuthor).subscribe((response: any) => {
      this.newAuthor = <Author>{};
      this.dialogVisible = false;
      this.loadAllAuthors();
      this.messageService.add({ severity: 'success', detail: 'Author successfully created' });
    })
  }

  showDeleteConfirmDialog(event: Event, author: Author) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: `Are you sure you want to delete author: <b>${author.name}</b>?`,
      header: 'Confirmation',
      icon: 'pi pi-exclamation-triangle',
      acceptLabel: 'Yes',
      acceptIcon: "pi pi-check mr-2",
      rejectLabel: 'No',
      rejectIcon: "pi pi-times mr-2",
      rejectButtonStyleClass: "p-button-text bg-primary",
      accept: () => {
        this.httpService.deleteDataById(Environment.AUTHOR, author.id).subscribe((response: any) => {
          this.loadAllAuthors();
          this.messageService.add({ severity: 'success', detail: 'Author successfully deleted' });
        })
      }
    });
  }
}
