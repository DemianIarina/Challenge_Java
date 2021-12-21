package com.company.Repository;

import com.company.Entities.Item;

import java.util.Objects;

public class ItemRepository extends InMemoryRepository<Item>{
    public ItemRepository() {
        super();
    }

    @Override
    public Item create(Item obj) {
        if(this.repoList.stream()
                .noneMatch(item -> Objects.equals(item.getName(), obj.getName())))
            super.create(obj);
        return obj;
    }

    //TODO look daca ii nevoie
    @Override
    public Item update(Item obj) {
        return null;
    }
}
