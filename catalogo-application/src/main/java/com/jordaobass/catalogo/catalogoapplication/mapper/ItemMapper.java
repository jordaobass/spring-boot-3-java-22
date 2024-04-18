package com.jordaobass.catalogo.catalogoapplication.mapper;

import com.jordaobass.catalogo.catalogoapplication.dto.request.NewItemRequest;
import com.jordaobass.catalogo.catalogoapplication.dto.response.ItemResponse;
import com.jordaobass.catalogo.catalogoapplication.entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item newItemToItem(NewItemRequest newItemRequest);

    ItemResponse itemToItemResponse(Item item);
}
