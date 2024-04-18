package com.jordaobass.catalogo.catalogoapplication.controller;

import com.jordaobass.catalogo.catalogoapplication.dto.request.NewItemRequest;
import com.jordaobass.catalogo.catalogoapplication.dto.response.ItemResponse;
import com.jordaobass.catalogo.catalogoapplication.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAll() {

        return ResponseEntity.ok(itemService.getAll());
    }

    @PostMapping
    public void Add(@RequestBody NewItemRequest request) {
        itemService.Add(request);
    }

}
