package com.GerenciadorItensSustentaveis.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GerenciadorItensSustentaveis.Model.Item;
import com.GerenciadorItensSustentaveis.Repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

	
	@Autowired
	private ItemRepository repository;
	
	
	
	@Override
	public Item salvar(Item item) {
		return repository.save(item);
		
	}

	@Override
	public Optional<Item> buscarPorId(UUID id) {
		return repository.findById(id);
	}

	@Override
	public List<Item> listarTodos() {
		
		return repository.findAll();
	}

	@Override
	public Item atualizar(UUID id, Item item) {

	    Item itemExistente = repository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Item não encontrado"));

	    itemExistente.setNome(item.getNome());
	    itemExistente.setQuantidade(item.getQuantidade());
	    itemExistente.setCategoria(item.getCategoria());

	    return repository.save(itemExistente);
	}

	@Override
	public void deletar(UUID id) {
		
		if(repository.existsById(id)) {
			repository.deleteById(id);
			
		}else {
			
			throw new
			RuntimeException("Item não encontrado");
			
		}
		
		
		
	}

}
