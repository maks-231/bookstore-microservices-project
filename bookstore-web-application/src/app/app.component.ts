import {Component} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
             selector: 'app-root',
             templateUrl: './app.component.html',
             styleUrls: ['./app.component.css']
           })
export class AppComponent {
  items: MenuItem[] | undefined;

  ngOnInit() {
    this.items = [
      {
        label: 'File',
        icon: 'pi pi-fw pi-file',
      },
      {
        label: 'Edit',
        icon: 'pi pi-fw pi-pencil',
      },
      {
        label: 'Users',
        icon: 'pi pi-fw pi-user',
      },
      {
        label: 'Events',
        icon: 'pi pi-fw pi-calendar',
      },
      {
        label: 'Quit',
        icon: 'pi pi-fw pi-power-off'
      }
    ];

  }

}
