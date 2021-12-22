package com.company.Repository;

import com.company.Entities.Item;

import java.util.Objects;

public class ItemRepository extends InMemoryRepository<Item>{
    public ItemRepository() {
        super();
    }

    //TODO look daca ii nevoie
    @Override
    public Item update(Item obj) {
        return null;
    }
}
