import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ItemService } from './item.service';
import { Item } from './item.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: true,
  styleUrl: './app.css',
  imports: [CommonModule, FormsModule, HttpClientModule],
  providers: [ItemService]
})
export class App implements OnInit {

  itens: Item[] = [];
  carregando = false;
  loading = false;
  erro: string | null = null;
  sucesso: string | null = null;

  novoItem: Omit<Item, 'id'> = {
    nome: '',
    quantidade: 1,
    categoria: ''
  };

  constructor(private itemService: ItemService, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    this.carregarItens();
  }

  carregarItens(): void {
    this.carregando = true;
    this.itemService.listar().subscribe({
      next: (dados) => {
        this.itens = dados;
        this.carregando = false;
        this.cdr.detectChanges();
      },
      error: () => {
        this.erro = 'Erro ao carregar itens. Verifique se o servidor está rodando.';
        this.carregando = false;
        this.cdr.detectChanges();
      }
    });
  }

  cadastrarItem(): void {
    this.loading = true;
    this.erro = null;
    this.sucesso = null;

    this.itemService.criar(this.novoItem).subscribe({
      next: (itemCriado) => {
        this.itens = [itemCriado, ...this.itens];
        this.sucesso = `Item "${itemCriado.nome}" cadastrado com sucesso!`;
        this.novoItem = { nome: '', quantidade: 1, categoria: '' };
        this.loading = false;
        this.cdr.detectChanges();
        setTimeout(() => {
          this.sucesso = null;
          this.cdr.detectChanges();
        }, 3000);
      },
      error: () => {
        this.erro = 'Erro ao cadastrar item. Tente novamente.';
        this.loading = false;
        this.cdr.detectChanges();
      }
    });
  }

  excluirItem(id: string): void {
    if (!confirm('Deseja excluir este item?')) return;

    this.itemService.excluir(id).subscribe({
      next: () => {
        this.itens = this.itens.filter(i => i.id !== id);
        this.cdr.detectChanges();
      },
      error: () => {
        this.erro = 'Erro ao excluir item.';
        this.cdr.detectChanges();
      }
    });
  }
}
