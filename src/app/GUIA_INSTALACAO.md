# 🌿 Gerenciador de Itens Sustentáveis — Frontend Angular

## 📋 Pré-requisitos

Você vai precisar instalar:
1. **Node.js** (obrigatório para usar Angular)
2. **Angular CLI** (ferramenta de linha de comando do Angular)

---

## 🚀 Passo a Passo — Do zero ao funcionando

### 1️⃣ Instalar o Node.js

Acesse: https://nodejs.org/pt/download

Baixe a versão **LTS (recomendada)** e instale normalmente.

Após instalar, abra o **Prompt de Comando** e verifique:
```
node -v
npm -v
```
Devem aparecer os números de versão (ex: v20.x.x).

---

### 2️⃣ Instalar o Angular CLI

No Prompt de Comando (como Administrador):
```
npm install -g @angular/cli
```

Verifique:
```
ng version
```

---

### 3️⃣ Criar o projeto Angular

Navegue até a pasta onde quer criar o projeto:
```
cd C:\Users\SeuNome\projetos
```

Crie o projeto:
```
ng new gerenciador-front --no-standalone --routing=false --style=css
```

Quando perguntar sobre SSR (Server-Side Rendering), responda **N (não)**.

Entre na pasta:
```
cd gerenciador-front
```

---

### 4️⃣ Copiar os arquivos

Substitua os seguintes arquivos pelos arquivos fornecidos:

| Arquivo fornecido         | Destino no projeto                                    |
|--------------------------|-------------------------------------------------------|
| `app.component.html`     | `src/app/app.component.html`                          |
| `app.component.ts`       | `src/app/app.component.ts`                            |
| `app.component.css`      | `src/app/app.component.css`                           |
| `app.module.ts`          | `src/app/app.module.ts`                               |
| `item.model.ts`          | `src/app/item.model.ts`                               |
| `item.service.ts`        | `src/app/item.service.ts`                             |
| `index.html`             | `src/index.html`                                      |

---

### 5️⃣ Configurar a URL do backend

Abra `src/app/item.service.ts` e verifique a URL:
```typescript
private apiUrl = 'http://localhost:8080/items';
```

Ajuste a porta `8080` se o seu Spring Boot rodar em outra porta.

---

### 6️⃣ Configurar o CORS no Spring Boot

O Spring Boot precisa permitir requisições do Angular.
Adicione esta anotação no seu Controller:

```java
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/items")
public class ItemController {
    // seus métodos aqui
}
```

---

### 7️⃣ Rodar o projeto

Com o Spring Boot rodando, abra outro terminal e execute:
```
ng serve
```

Acesse no navegador:
```
http://localhost:4200
```

---

## 📁 Estrutura final do projeto

```
src/
  app/
    app.component.html   ← Tela principal (form + tabela)
    app.component.ts     ← Lógica da tela
    app.component.css    ← Estilos
    app.module.ts        ← Configuração do módulo Angular
    item.model.ts        ← Interface do Item (tipagem)
    item.service.ts      ← Serviço HTTP (fala com o Spring Boot)
  index.html             ← HTML base (Bootstrap importado aqui)
```

---

## 🔗 Como funciona a comunicação

```
Angular (porta 4200)  →  Spring Boot (porta 8080)
     GET /items            → lista todos os itens
     POST /items           → cria novo item
     DELETE /items/{id}    → exclui item
```

---

## ❓ Dúvidas comuns

**Erro: "Blocked by CORS"**
→ Adicione `@CrossOrigin` no Controller do Spring Boot (ver passo 6).

**Erro: "ng não é reconhecido"**
→ Feche e abra o terminal novamente após instalar o Angular CLI.

**A lista não atualiza**
→ O Angular atualiza automaticamente quando você adiciona um item via formulário.
   Se quiser recarregar do banco, clique em F5.
