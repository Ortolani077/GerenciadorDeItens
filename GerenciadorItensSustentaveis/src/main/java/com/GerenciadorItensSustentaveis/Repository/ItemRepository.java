package com.GerenciadorItensSustentaveis.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GerenciadorItensSustentaveis.Model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

}
