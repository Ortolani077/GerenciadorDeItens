import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Item } from './item.model';

@Injectable({
  providedIn: 'root'
})
export class ItemService {

  private apiUrl = 'http://localhost:8080/itens';

  constructor(private http: HttpClient) {}

  listar(): Observable<Item[]> {
    return this.http.get<Item[]>(`${this.apiUrl}/listartodos`);
  }

  criar(item: Omit<Item, 'id'>): Observable<Item> {
    return this.http.post<Item>(`${this.apiUrl}/salvar`, item);
  }

  buscarPorId(id: string): Observable<Item> {
    return this.http.get<Item>(`${this.apiUrl}/${id}`);
  }

  atualizar(id: string, item: Item): Observable<Item> {
    return this.http.put<Item>(`${this.apiUrl}/atualizar/${id}`, item);
  }

  excluir(id: string): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
