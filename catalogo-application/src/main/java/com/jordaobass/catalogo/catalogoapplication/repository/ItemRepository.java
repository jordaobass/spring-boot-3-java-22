package com.jordaobass.catalogo.catalogoapplication.repository;

import com.jordaobass.catalogo.catalogoapplication.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
