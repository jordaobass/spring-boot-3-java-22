package com.jordaobass.catalogo.catalogoapplication.service;

import com.jordaobass.catalogo.catalogoapplication.dto.request.NewItemRequest;
import com.jordaobass.catalogo.catalogoapplication.dto.response.ItemResponse;
import com.jordaobass.catalogo.catalogoapplication.mapper.ItemMapper;
import com.jordaobass.catalogo.catalogoapplication.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    public List<ItemResponse> getAll() {

        List<ItemResponse> list = new ArrayList<>();
        var itens = itemRepository.findAll();

        itens.forEach(s -> list.add(itemMapper.itemToItemResponse(s)));

        return list;
    }

    public void Add(NewItemRequest newItemRequest) {

        var item = itemMapper.newItemToItem(newItemRequest);

        itemRepository.save(item);
    }


}
