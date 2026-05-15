package com.GerenciadorItensSustentaveis.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GerenciadorItensSustentaveis.Model.Item;
import com.GerenciadorItensSustentaveis.Service.ItemService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/itens")
public class ItemController {

	@Autowired
	private ItemService service;

	@PostMapping("/salvar")
	public Item salvar(@RequestBody Item item) {
	    item.setId(UUID.randomUUID()); // ← adiciona essa linha


		return service.salvar(item);

	}

	@GetMapping("/listartodos")
	public List<Item> listarTodos() {

		return service.listarTodos();

	}
	
	
	@GetMapping("/{id}")
	public Item buscarPorID(@PathVariable UUID id) {
		
		return service.buscarPorId(id)
				.orElseThrow(() -> new RuntimeException("Item não encontrado"));
		
		
		
	}
	
	
	@PutMapping("/atualizar/{id}")
	public Item atualizar(@PathVariable UUID id, @RequestBody Item item) {
		 return service.atualizar(id, item);
		
		
	}
	
	@DeleteMapping("/{id}") 
	public void deletar(@PathVariable UUID id) {
		
		service.deletar(id);
	}
	

}
