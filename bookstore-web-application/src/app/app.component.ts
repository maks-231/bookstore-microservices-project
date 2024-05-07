import { Component } from '@angular/core';
import { MenuItem } from "primeng/api";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  items: MenuItem[] | undefined;

  constructor() { }

  ngOnInit() {
    this.populateMenuItems();
  }

  populateMenuItems() {
    this.items = [
      {
        label: 'Books',
        icon: 'pi pi-fw pi-book',
        routerLink: 'books',
        items: [
          {
            separator: true
          },
          {
            label: 'Add',
            icon: 'pi pi-fw pi-plus',
            routerLink: 'book/create'
          }
        ]
      },
      {
        label: 'Genres',
        icon: 'pi pi-fw pi-pencil',
        routerLink: 'genres'
      },
      {
        label: 'Authors',
        icon: 'pi pi-fw pi-user',
        routerLink: 'authors'
      },
      {
        label: 'Publishers',
        icon: 'pi pi-fw pi-verified',
        routerLink: 'publishers'
      }
    ];
  }

}
