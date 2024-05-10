import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Environment } from 'src/environment/environment';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  serverUrl: string = Environment.URL;

  constructor(private httpClient: HttpClient) { }

  getAllData(url: string): any {
    return this.httpClient.get(this.serverUrl + url);
  }

  getBookByIsbn(isbn: any): any {
    return this.httpClient.get(this.serverUrl + Environment.BOOK + '/' + isbn)
  }

  getBooksByGenre(genreId: number): any {
    return this.httpClient.get(this.serverUrl + Environment.BOOK + '/genre/' + genreId)
  }

  createData(url: string, body: any): any {
    return this.httpClient.post(this.serverUrl + url, body);
  }

  updateData(url: string, body: any): any {
    return this.httpClient.put(this.serverUrl + url, body);
  }

  deleteDataById(url: string, id: any): any {
    return this.httpClient.delete(`${this.serverUrl}${url}/${id}`)
  }
}
