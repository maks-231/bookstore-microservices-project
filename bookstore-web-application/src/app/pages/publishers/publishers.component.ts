import { Component } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Publisher } from 'src/app/models/publisher';
import { HttpService } from 'src/app/services/http.service';
import { Environment } from 'src/environment/environment';

@Component({
  selector: 'app-publishers',
  templateUrl: './publishers.component.html',
  styleUrl: './publishers.component.css',
  providers: [MessageService, ConfirmationService]
})
export class PublishersComponent {

  editing: boolean = false;
  dialogVisible: boolean = false;
  publishers: Publisher[] = [];
  newPublisher: Publisher = <Publisher>{};

  clonedPublishers: { [s: string]: Publisher } = {};

  constructor(private httpService: HttpService, private messageService: MessageService, private confirmationService: ConfirmationService) { }

  ngOnInit(): void {
    this.loadAllPublishers();
  }

  loadAllPublishers() {
    this.httpService.getAllData(Environment.PUBLISHER).subscribe((response: Publisher[]) => this.publishers = response);
  }

  onRowEditSave(publisher: Publisher) {
    this.httpService.updateData(Environment.PUBLISHER, publisher).subscribe((response: any) => {
      this.loadAllPublishers();
      this.messageService.add({ severity: 'success', detail: 'Publisher succsessfully updated' });
    }, () => {
      this.messageService.add({ severity: 'error', detail: 'Something went wrong' });
      this.loadAllPublishers();
    } )
  }

  onCreateNewPublisherClick() {
    this.httpService.createData(Environment.PUBLISHER, this.newPublisher).subscribe((response: any) => {
      this.newPublisher = <Publisher>{};
      this.dialogVisible = false;
      this.loadAllPublishers();
      this.messageService.add({ severity: 'success', detail: 'Publisher successfully created!' });
    })
  }

  showDeleteConfirmDialog(event: Event, publisher: Publisher) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: `Are you sure you want to delete publisher: <b>${publisher.name}</b>?`,
      header: 'Confirmation',
      icon: 'pi pi-exclamation-triangle',
      acceptLabel: 'Yes',
      acceptIcon: "pi pi-check mr-2",
      rejectLabel: 'No',
      rejectIcon: "pi pi-times mr-2",
      rejectButtonStyleClass: "p-button-text bg-primary",
      accept: () => {
        this.httpService.deleteDataById(Environment.PUBLISHER, publisher.id).subscribe((response: any) => {
          this.loadAllPublishers();
          this.messageService.add({ severity: 'success', detail: 'Publisher successfully deleted' });
        })
      }
    });
  }
}
