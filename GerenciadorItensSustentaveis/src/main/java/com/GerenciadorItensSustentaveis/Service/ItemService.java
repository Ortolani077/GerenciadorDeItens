package com.GerenciadorItensSustentaveis.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.GerenciadorItensSustentaveis.Model.Item;

public interface ItemService  {
	
	Item salvar(Item item);
	
	Optional <Item> buscarPorId (UUID id);
	
	List<Item> listarTodos();
	
	Item atualizar(UUID id, Item item);
	
	void deletar(UUID id);
	

}
